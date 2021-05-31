import math
import cmath
import random
import operator
# from math import cos

print(dir(math))
print(dir(cmath))

m = math.cos(90)
cm = cmath.cos(90)

print(m)
print(cm)

rc = random.choice(range(10, 100, 2))
print(rc)

ru = random.uniform(100, 200)
print(ru)

print(3 * math.pi)

ol = operator.lt(10, 15)
print(ol)

print(bin(12345).replace("0b", ""))
print("{0:b}".format(12345))
