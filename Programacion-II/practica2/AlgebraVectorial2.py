import math
class AlgebraVectorial:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z
    def __str__(self):
        return f"({self.x}, {self.y}, {self.z})"
    def __add__(self, otro):
        return AlgebraVectorial(self.x + otro.x, self.y + otro.y, self.z + otro.z)
    def __sub__(self, otro):
        return AlgebraVectorial(self.x - otro.x, self.y - otro.y, self.z - otro.z)
    def producto_escalar(self, otro):
        return self.x * otro.x + self.y * otro.y + self.z * otro.z
    def producto_vectorial(self, otro):
        cx = self.y * otro.z - self.z * otro.y
        cy = self.z * otro.x - self.x * otro.z
        cz = self.x * otro.y - self.y * otro.x
        return AlgebraVectorial(cx, cy, cz)
    def longitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)
    def normal(self):
        l = self.longitud()
        return AlgebraVectorial(self.x/l, self.y/l, self.z/l)
    def es_perpendicular(self, otro):
        return self.producto_escalar(otro) == 0
    def es_paralelo(self, otro):
        cruz = self.producto_vectorial(otro)
        return cruz.x == 0 and cruz.y == 0 and cruz.z == 0
    def proyeccion_sobre(self, otro):
        esc = self.producto_escalar(otro)
        mod_b2 = otro.longitud() ** 2
        factor = esc / mod_b2
        return AlgebraVectorial(otro.x * factor, otro.y * factor, otro.z * factor)
    def componente_en(self, otro):
        return self.producto_escalar(otro) / otro.longitud()

a = AlgebraVectorial(1, 2, 3)
b = AlgebraVectorial(2, 4, 6)
print("a =", a)
print("b =", b)
print("Suma:", a + b)
print("Resta:", a - b)
print("Producto escalar:", a.producto_escalar(b))
print("Producto vectorial:", a.producto_vectorial(b))
print("Longitud de a:", a.longitud())
print("Normal de a:", a.normal())
print("¿a ⟂ b?", a.es_perpendicular(b))
print("¿a ∥ b?", a.es_paralelo(b))
print("Proyección de a sobre b:", a.proyeccion_sobre(b))
print("Componente de a en b:", a.componente_en(b))
