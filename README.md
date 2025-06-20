# Árbol Binario de Búsqueda: Altura, Peso y Equilibrio

## 📌 Información General

- **Título:** Práctica de Estructuras No Lineales
- **Asignatura:** Estructura de Datos
- **Carrera:** Computación
- **Estudiante:** Erick Bermeo
- **Fecha:** 20/06/2025
- **Profesor:** Ing. Pablo Torres

## Getting Started

Este repositorio corresponde a una práctica de la asignatura **Estructura de Datos**, en la que se implementa un **árbol binario de búsqueda** (ABB) en Java. El objetivo es construir el árbol, insertar nodos, recorrerlo en orden, calcular su altura, peso y analizar si está equilibrado.

---

## Requirements

* **Java JDK 11** o superior.
* **NetBeans 12** o superior (opcional).
* **Git 2.20** o superior.

---

## Definición del Proyecto

El árbol binario de búsqueda permite almacenar datos ordenados para búsquedas eficientes. En este proyecto, se insertan varios nodos en el árbol, se imprimen recorridos y características como:

- Peso (cantidad de nodos)
- Altura del árbol
- Recorrido InOrder
- Altura por nodo
- Factor de equilibrio por nodo
- Si el árbol está equilibrado o no
- Nodos desequilibrados

---

## Estructura del Proyecto

El proyecto contiene las siguientes clases:

- `Node`: representa un nodo del árbol.
- `BinaryTree`: clase principal con métodos de inserción, recorridos, altura, peso y equilibrio.
- `App`: clase principal que ejecuta la práctica solicitada.

---

## Instrucciones

1. **Revisa el código de `BinaryTree.java`**

Incluye métodos como:
- `insert(int value)`
- `peso()`
- `altura()`
- `inOrder()`
- `inOrderAlturas()`
- `inOrderBalance()`
- `nodosDesequilibrados()`
- `estaBalanceado()`
- `findeValue(int valor)`

2. **Ejecuta la clase `App.java`**

Esta clase inserta nodos y luego imprime lo siguiente en consola:

![Salida de consola](img/Captura.png)
