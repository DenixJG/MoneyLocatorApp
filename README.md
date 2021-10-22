# Money Locator App

---

App centrada localizar dinero en efectivo con la ayuda de colaboradores (Usuario), estos ingresarán el número de
identificación que tiene cada billete y se procederá a buscar en la base de datos si ese billete tiene información si no
es el caso se le preguntara al usuario si desea agregar datos sobre el billete.

## Estructura de la App
Ventanas de la App y componentes `Swing` usados en todas las ventanas.

### Ventanas de la App.
La app se compone de diversas ventanas por las que el usuario se mueve

### Componentes Swing.
La app hace uso de diferentes componentes `Swing` en cada ventana.

## Estructura de la Base de Datos (MySQL o MongoDB)
Estructura y relaciones de la base de datos

### Estructura de las cuentas de usuarios.
Las cuentas de usuario tendrán un **identificador único** que será el que se use para administrar tareas para
cada usuario.

**(MongoDB)Estructura de usuario:**
```json
{
  "_id": "",
  "username": "",
  "email": "",
  "password": ""
}
```

**(MySQL)Estructura de usuario:**

| Campo             | Valor       |
|-------------------|-------------|
| **uuid**          | String      |
| **username**      | String      |
| **email**         | String      |
| **password**      | String      |

### Estructura de los datos. 