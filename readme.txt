#  Turnero en Java (proyecto en proceso)

Sistema de gestión de turnos hecho en Java desde cero.  
Lo arranqué sin saber casi nada, pero fui aprendiendo de a poco, anotando todo en una libreta y corrigiendo cosas sobre la marcha.

---

## ¿Qué hace esto?

Es un programa por consola que te deja:
- Agregar pacientes (con nombre y DNI)
- Ver la lista de pacientes
- Agendar turnos para esos pacientes
- Ver los turnos registrados

No tiene base de datos ni archivos todavía. Todo se borra cuando cerrás el programa (por ahora).

---


##  Versiones y cambios

###  v0.1 — Estructura base
- Creé las clases `Paciente`, `Turno` y `GestorTurnos`
- Usé `ArrayList` para guardar pacientes y turnos
- Hice que funcione todo desde un `Main.java` con menú por consola
- Primera vez que usé `Scanner` en serio

###  v0.2 — Código más limpio
- Reemplacé el `if` del menú por `switch`
- Empecé a usar `@Override` en `toString()` como buena práctica
- Validé que el `Scanner` se cierre bien al salir
- Aprendí qué es tipado fuerte y que hay que declarar todo

## v0.3 - arranqué con guardar los pacientes y turnos en archivos '.txt'
- File reader e writers para archivos '.txt'
- `BuferedWriters` e imported io y Scanner en Main

## v0.4 - DNI no se duplique 
- bool de checkeo de DNI
- alert ante repeticion y break de cadena

## v0.5 - Hora en turnos
- cambie gestor, turno(dni fecha y hora ahora) y Main

## v0.6 - opcion de cancelar
- cancelar entra en juego

## v0.7 - no repite turno
- ahora se checkea que si el horario esta dado no permite

### Próximas versiones que tengo en mente (ideas en la libreta)
- v1.0 → Quizás una interfaz gráfica simple

---

## Cómo correrlo

Necesitás tener Java instalado. Probado con JDK 11+.

1. Abrí una terminal en la carpeta del proyecto.
2. Compilá los archivos:
   ```bash
   javac *.java
