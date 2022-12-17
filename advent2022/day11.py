
from collections import namedtuple, deque
from itertools import takewhile
import operator
from typing import List, Tuple, TypeVar, Self, TextIO


OPS = {
    0: operator.add,
    1: operator.sub,
    2: operator.mul,
    3: operator.floordiv,
    4: lambda x, y: int((x % y) == 0),
    5: operator.pow,
}


class Op:
    PLUS = 0
    SUBTRACT = 1
    MULTIPLY = 2
    DIVIDE = 3
    DIVISIBLE_BY = 4
    POWER = 5

    @staticmethod
    def exec(op: int, worry: int, value: int) -> int:
        f = OPS[op]
        return f(worry, value)

    @staticmethod
    def parse(input_str: str) -> Tuple[int, int]:
        parts = input_str.split()
        op = None

        if parts[-2] == '+':
            op = (Op.PLUS, int(parts[-1]))
        elif parts[-2] == '*':
            if parts[-1] == 'old':
                op = (Op.POWER, 2)
            else:
                oip = (Op.MULTIPLY, int(parts[-1]))
        elif parts[-3] == 'divisible':
            op = (Op.DIVISIBLE_BY, int(parts[-1]))

        return op


class Monkey:

    def __init__(
        self, 
        n: int, 
        items: List[int], 
        op: Tuple[int, int], 
        test: Tuple[int, int],
        action: Tuple[int, int],
    ):
        self.n = n
        self.items = deque(items)
        self.op = op
        self.test = test
        self.action = action
        self.inspected = 0

    @staticmethod
    def parse(lines: List[str]) -> Self:
        n = None
        items = deque()
        op = None
        test = None
        action_true = None
        action_false = None

        for line in lines:
            line = line.strip()
            if line.startswith('Monkey '):
                n = int(line[7:-1])
            elif line.startswith('Starting items: '):
                items = deque(int(item.strip()) for item in line[16:].split(','))
            elif line.startswith('Operation: '):
                op = Op.parse(line[11:])
            elif line.startswith('Test: '):
                test = Op.parse(line[6:])
            elif line.startswith('If true: '):
                action_true = int(line.split()[-1])
            elif line.startswith('If false: '):
                action_false = int(line.split()[-1])

        return Monkey(n, items, op, test, (action_true, action_false))

    def inspect(self, worry: int) -> Tuple[int, int]:
        (op, value) = self.op
        worry = Op.exec(op, worry, value)
        worry = worry // 3

        (test, value) = self.test
        (action_true, action_false) = self.action
        if Op.exec(test, worry, value):
            target = action_true
        else:
            target = action_false

        self.inspected += 1
        return (target, worry)
        
    def inspect_all(self) -> List[Tuple[int, int]]:
        output = []

        while self.items:
            current = self.items.popleft()
            pair = self.inspect(current)
            output.append(pair)

        return output


def run_a(monkey_data: TextIO) -> int:
    lines = iter(monkey_data)
    monkeys = []
    while True:
        block = list(takewhile(lambda l: l.strip(), lines))
        if not block:
            break
        monkeys.append(Monkey.parse(block))

    for n in range(20):
        for monkey in monkeys:
            for target, worry in monkey.inspect_all():
                monkeys[target].items.append(worry)

    monkeys.sort(reverse=True, key=operator.attrgetter('inspected'))
    a, b = monkeys[:2]

    return a.inspected * b.inspected


def main():
    with open('./src/main/resources/data/day11.txt') as f:
        print(run_a(f))
        # 120384


if __name__ == '__main__':
    main()