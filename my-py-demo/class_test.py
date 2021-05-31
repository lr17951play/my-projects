class Employee:
    """所有员工的基类"""
    empCount = 0
    _employeeNo = 0

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        self._employeeNo = salary * 101
        Employee.empCount += 1

    def __del__(self):
        print("销毁对象：", self.name)

    def displayCount(self):
        print("Total Employee %d" % Employee.empCount)

    def displayEmployee(self):
        print("Name : ", self.name, ", Salary: ", self.salary, ", EmployeeNo: ", self._employeeNo)


print(Employee.__doc__)
e = Employee("lirui", 10)
t = Employee("Tom", 20)
r = Employee("Rey", 30)
e.displayCount()
e.displayEmployee()
t.displayEmployee()
r.displayEmployee()

print(hasattr(Employee, "age"))
print(setattr(e, "salary", 50))
print(getattr(e, "salary"))

del e
del t


class ChildEmp (Employee):

    age = 0
    __account = 0

    def __init__(self, name, salary, age):
        self.name = name
        self.salary = salary
        self.age = age
        self._employeeNo = salary * 1001
        self.__calcAccount()

    def displayEmployee(self):
        print("Siemens Emps Name:", self.name, ", Salary:", self.salary, ", with age:", self.age)

    def __calcAccount(self):
        self.__account += 1
        print(self.__account, ", EmployeeNo: ", self._employeeNo)


ce = ChildEmp("James", 50, 18)
ce.displayEmployee()
ce2 = ChildEmp("Aye", 123, 15)
