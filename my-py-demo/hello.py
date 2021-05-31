import hello2

b = -1
print("Answer:")  # Hello Comment!
if b > 0:
    print("greater then zero")
elif b == 0:
    print("equals zero")
else:
    print("less than zero")

# raw_input("按下 enter 键退出，其他任意键显示...\n")
s = 'This is my test string'
print(s[0:15:3])
print(s * 2)
print(s[1: -1])
print(s + "\n" + "lalalalala")
print(s + r'\n' + "lalalalala")

print(type(b), type(s))

a = isinstance(s, str)
print(a)

cal_a, cal_b = 100, 30

print(cal_a // cal_b)
print(cal_a % cal_b)
print(cal_a ** cal_b)

lst = ['xyz', 123, True, 456.321, "abc"]
sub_lst = ["cba", 321]

lst[1] = 1234
print(lst[1:3])
print(sub_lst * 2)
print(lst + sub_lst)

tup = ('abcd', 786 , 2.23, 'runoob', 70.2)
sub_tup = (123, 'runoob')

print(tup[1:3])
print(sub_tup * 2)
print(tup + sub_tup)

# example
if __name__ == "__main__":
    inp = 'I like runoob'
    rw = hello2.reverseWords(inp)
    print(rw)
    rw = hello2.suum(100000000000, 999999999)
    print(rw)

set_peop = {"Tom", "Ryan", "Jessica", "Jack"}
if "Tom" in set_peop:
    print("Tom is here!")

set_a = set("abcdacdbadcdbcacbadcba")
set_b = set("kaakakakakaka")
print(set_a, set_b)
print(set_a - set_b)  # 差集
print(set_a | set_b)  # 并集
print(set_a & set_b)  # 交集
print(set_a ^ set_b)  # 不同时存在的元素

# dic_a = {x: x**2 for x in (2, 4, 6)}
dic_a = dict([('Runoob', 1), ('Google', 2), ('Taobao', 3)])
print(dic_a['Google'])
print(dic_a.keys())
print(dic_a.values())

is_a, is_b = 1, 1

if (is_a is is_b):
    print(id(is_a), id(is_b), "true, Equals")

for x in [1, 2, 3]: print(x, end="--->")

set_x = {x for x in 'abracadabra' if x not in 'abc'}
set_x.pop();
print(set_x)

a, b = 0, 1
while b < 10:
    print(b, end="=====>")
    a, b = b, a+b

print(globals())
print(locals())
