import math
class AlgebraVectorial:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def __add__(self, otro):
        return AlgebraVectorial(self.x + otro.x, self.y + otro.y)
    def __sub__(self, otro):
        return AlgebraVectorial(self.x - otro.x, self.y - otro.y)
    def __mul__(self, otro):
        return self.x * otro.x + self.y * otro.y
    def __str__(self):
        return f"({self.x}, {self.y})"
    def modulo(self):
        return math.sqrt(self.x**2 + self.y**2)
    def perpendicular_suma_resta(self, otro):
        return math.isclose((self + otro).modulo(), (self - otro).modulo())
    def perpendicular_mutua(self, otro):
        return math.isclose((self - otro).modulo(), (otro - self).modulo())
    def perpendicular_producto(self, otro):
        return (self * otro) == 0
    def perpendicular_pitagoras(self, otro):
        return math.isclose((self + otro).modulo()**2, self.modulo()**2 + otro.modulo()**2)
    def paralela_proporcion(self, otro):
        if otro.x == 0 and otro.y == 0:
            return False
        return math.isclose(self.x * otro.y, self.y * otro.x)
    def paralela_cruz(self, otro):
        return math.isclose(self.x * otro.y - self.y * otro.x, 0.0)
    def proyeccion(self, otro):
        escalar = (self * otro) / (otro.modulo()**2)
        return AlgebraVectorial(otro.x * escalar, otro.y * escalar)
    def componente(self, otro):
        return (self * otro) / otro.modulo()
a = AlgebraVectorial(3, 0)
b = AlgebraVectorial(0, 4)
print("a =", a)
print("b =", b)
print("¿Perpendiculares (|a+b|=|a-b|)?", a.perpendicular_suma_resta(b))
print("¿Perpendiculares (a·b=0)?", a.perpendicular_producto(b))
print("¿Paralelas (proporción)?", a.paralela_proporcion(b))
print("Proyección de a sobre b:", a.proyeccion(b))
print("Componente de a en b:", a.componente(b))
