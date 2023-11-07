# Prueba Técnica Nº 1 - Java Básico 

****

**El backup de la base datos está en la carpeta main/resource del proyecto**

## Desarrollo de una Aplicación de Gestión de Empleados

### Tecnologías
1. Java
2. Mysql
3. JPA
### Funcionamiento de la aplicación
La aplicación empieza ejecutándose desde el mismi Intellij IDE dando en el botón **Run Main** y una vez empiece
a correr el programa nos aparecerá algo parecido a esto: 

<pre>
Choose one of the options:
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 
</pre>
#### Opción 1 del menú (Crear empleado)
En este menú elegiremos la opción que queramos realizar. Por ejemplo si queremos ingresar un empleado elegiremos
la opción 1. En esta opción tendremos lo siguiente:

<pre>
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 1
Enter the employee's name: 
Carlota
Enter the employee's last name 
Gutierrez Fernandez
Enter the employee's job title: 
Administrativo
Enter the employee's salary: 
1514,14
Enter the employee's date of employment (dd-MM-yyyy): 
25-04-2019
Thank you! Employee created successfully.
</pre>

Como podremos observar nos va pidiendo los datos que necesitamos para agregar al empleado en la base de datos y por último si todo a salido bien,
nos dirá que el empleado se ha creado satisfactoriamente.

#### Opción 2 del menú (Listar los empleados de la base de datos)
En esta opción nos mostrará todo el listado de los empleados que tenemos en ese momento guardado en nuestra base de datos.

<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 2

------------Employee data--------------
id: 1
name: María
surname: Gracía García
jobTittle: Administrativo
Date of Employment: 2013-11-12
salary: 1245.15
----------------------------------------
id: 2
name: Francisco Matías
surname: Molina Jurado
jobTittle: Programador junior
Date of Employment: 2022-12-12
salary: 1452.12
----------------------------------------
id: 3
name: Carlos
surname: Jimenez García
jobTittle: Programador senior
Date of Employment: 2010-12-25
salary: 2450.45
----------------------------------------
id: 4
name: Hugo
surname: Molina Rienda
jobTittle: Analista
Date of Employment: 2020-05-26
salary: 2002.45
----------------------------------------
id: 5
name: Noemi
surname: Rienda Rodriguez
jobTittle: Contabilidad
Date of Employment: 2021-08-24
salary: 1564.23
----------------------------------------
id: 6
name: Óscar
surname: García Hernández
jobTittle: Contabilidad
Date of Employment: 2015-02-18
salary: 2120.12
----------------------------------------
id: 7
name: Julio
surname: Molina Jimenez
jobTittle: Analista
Date of Employment: 2005-01-19
salary: 2300.5
----------------------------------------
id: 8
name: Lucía
surname: Pérez Garbañosa
jobTittle: Administrativo
Date of Employment: 2001-03-28
salary: 2451.25
----------------------------------------
id: 9
name: Alejandro
surname: García Gracia
jobTittle: Programador senior
Date of Employment: 2006-04-29
salary: 2614.45
----------------------------------------
id: 10
name: Maria del Carmen
surname: Fernandez Fernandez
jobTittle: Programador senior
Date of Employment: 2017-09-26
salary: 2310.45
----------------------------------------
id: 11
name: Noelia
surname: Guzmán Guzmán
jobTittle: Administrativo
Date of Employment: 2011-08-05
salary: 1561.12
----------------------------------------
id: 12
name: Julian
surname: Torres Torres
jobTittle: Analista
Date of Employment: 2021-08-05
salary: 1452.14
----------------------------------------
id: 13
name: Agustín
surname: Berlanga García
jobTittle: Contabilidad
Date of Employment: 2018-06-02
salary: 1452.12
----------------------------------------
id: 14
name: Alicia
surname: García Molina
jobTittle: Programador junior
Date of Employment: 2022-12-05
salary: 1241.14
----------------------------------------
id: 15
name: Verónica
surname: Pérez Aragón
jobTittle: Programador junior
Date of Employment: 2023-01-12
salary: 1452.25
----------------------------------------
id: 16
name: Lourdes
surname: Chacón Vigo
jobTittle: Programador senior
Date of Employment: 2023-03-12
salary: 2478.45
----------------------------------------
id: 17
name: Miguel Ángel
surname: Rienda García
jobTittle: Contabilidad
Date of Employment: 2023-05-12
salary: 2421.1
----------------------------------------
id: 18
name: Carlota
surname: Gutierrez Fernandez
jobTittle: Administrativo
Date of Employment: 2019-04-25
salary: 1514.14
----------------------------------------
</pre>


#### Opción 3 del menú (Actualizar empleado)
En esta opción del menú cómo bien dice el enunciado es actualiazar los datos del empleado buscado por Id.
Por ejemplo, queremos actualizar el empleado con Id = 18 porque el cargo y la fecha no son las correctas, entonces nos mostraría algo parecido a esto:
<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 3
Enter the ID of the employee to search: 18

------Employed before being modified------
id: 18
name: Carlota
surname: Gutierrez Fernandez
jobTittle: Administrativo
Date of Employment: 2019-04-25
salary: 1514.14

Enter the employee's name : 
Carlota
Enter the employee's last name 
Gutierrez Fernandez
Enter the employee's job title: 
Analista
Enter the employee's salary: 
1514,14
Enter the employee's date of employment (dd-MM-yyyy): 
24-04-2019

------Employed after being modified------
id: 18
name: Carlota
surname: Gutierrez Fernandez
jobTittle: Analista
Date of Employment: 2019-04-24
salary: 1514.14
</pre>

Como podremos observar que hemos cambiado el cargo y la fecha y eso quedaría guardado en la base de datos.

#### Opción 4 (Borrar empleado)
En este apartado lo que vamos hacer y como podemos imaginar es la de borrar un empleado de la base de datos, así que vamos a borrar el último registro que es el 18

<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 4
Enter employee ID to delete: 
18
Employee found:
id: 18
name: Carlota
surname: Gutierrez Fernandez
jobTittle: Analista
Date of Employment: 2019-04-24
salary: 1514.14
Are you sure you want to delete this employee? (Y/N): 
y

Employee deleted successfully.
</pre>
Y si listamos los empleados podremos ver que ya no está 
<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 2

------------Employee data--------------
id: 1
name: María
surname: Gracía García
jobTittle: Administrativo
Date of Employment: 2013-11-12
salary: 1245.15
----------------------------------------
id: 2
name: Francisco Matías
surname: Molina Jurado
jobTittle: Programador junior
Date of Employment: 2022-12-12
salary: 1452.12
----------------------------------------
id: 3
name: Carlos
surname: Jimenez García
jobTittle: Programador senior
Date of Employment: 2010-12-25
salary: 2450.45
----------------------------------------
id: 4
name: Hugo
surname: Molina Rienda
jobTittle: Analista
Date of Employment: 2020-05-26
salary: 2002.45
----------------------------------------
id: 5
name: Noemi
surname: Rienda Rodriguez
jobTittle: Contabilidad
Date of Employment: 2021-08-24
salary: 1564.23
----------------------------------------
id: 6
name: Óscar
surname: García Hernández
jobTittle: Contabilidad
Date of Employment: 2015-02-18
salary: 2120.12
----------------------------------------
id: 7
name: Julio
surname: Molina Jimenez
jobTittle: Analista
Date of Employment: 2005-01-19
salary: 2300.5
----------------------------------------
id: 8
name: Lucía
surname: Pérez Garbañosa
jobTittle: Administrativo
Date of Employment: 2001-03-28
salary: 2451.25
----------------------------------------
id: 9
name: Alejandro
surname: García Gracia
jobTittle: Programador senior
Date of Employment: 2006-04-29
salary: 2614.45
----------------------------------------
id: 10
name: Maria del Carmen
surname: Fernandez Fernandez
jobTittle: Programador senior
Date of Employment: 2017-09-26
salary: 2310.45
----------------------------------------
id: 11
name: Noelia
surname: Guzmán Guzmán
jobTittle: Administrativo
Date of Employment: 2011-08-05
salary: 1561.12
----------------------------------------
id: 12
name: Julian
surname: Torres Torres
jobTittle: Analista
Date of Employment: 2021-08-05
salary: 1452.14
----------------------------------------
id: 13
name: Agustín
surname: Berlanga García
jobTittle: Contabilidad
Date of Employment: 2018-06-02
salary: 1452.12
----------------------------------------
id: 14
name: Alicia
surname: García Molina
jobTittle: Programador junior
Date of Employment: 2022-12-05
salary: 1241.14
----------------------------------------
id: 15
name: Verónica
surname: Pérez Aragón
jobTittle: Programador junior
Date of Employment: 2023-01-12
salary: 1452.25
----------------------------------------
id: 16
name: Lourdes
surname: Chacón Vigo
jobTittle: Programador senior
Date of Employment: 2023-03-12
salary: 2478.45
----------------------------------------
id: 17
name: Miguel Ángel
surname: Rienda García
jobTittle: Contabilidad
Date of Employment: 2023-05-12
salary: 2421.1
----------------------------------------
</pre>

#### Opción 5 (Buscar personas por cargo en la empresa)
En este apartado lo que vamos a obtener son los empleados por cargo o puesto que tienen en la empresa, para ello elegimos la opción 5 vamos a buscar a programadores junior:

<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 5
Enter the position of the employee to search: 
programador junior

id: 2
name: Francisco Matías
surname: Molina Jurado
jobTittle: Programador junior
Date of Employment: 2022-12-12
salary: 1452.12
----------------------------------------

id: 14
name: Alicia
surname: García Molina
jobTittle: Programador junior
Date of Employment: 2022-12-05
salary: 1241.14
----------------------------------------

id: 15
name: Verónica
surname: Pérez Aragón
jobTittle: Programador junior
Date of Employment: 2023-01-12
salary: 1452.25
----------------------------------------
</pre>

El sistema ignora entre mayúsculas y minúsculas, así que si en la base de datos tenenos el cargo con mayúsculas, en el buscador podremos y usar indistintamente mayúsculas o minúsculas.


## Errores que nos podremos encontrar.

Los errores típicos que nos podremos encontrar en esta app es por ejemplo que cuando estemos agregado un usuario que nos equivoquemos a la hora de ingresar el nombre, el salario o cualquier opción,
para ello tendremos varias advertencias que nos dirá que nos hemos equivocado así podremos rectificar los datos que hemos introducido. 

Por ejemplo un error muy común es que te equivoques a la hora de agregar el nombre y sin querer agregues un número cuando no toca, entonces nos saldría el siguiente error: 

<pre>
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 1
Enter the employee's name: 
María3
Invalid name, please enter a valid name
</pre>
Y si le damos al enter sin rellenar el campo del nombre también nos saltará el mismo error y así sucesivamente con los demás campos.
En la fecha por ejemplo no podremos agregar una fecha en el futuro, por ejemplo:

<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 1
Enter the employee's name: 
María3
Invalid name, please enter a valid name
Elena
Enter the employee's last name 
García Perogrullo
Enter the employee's job title: 
Programador senior
Enter the employee's salary: 
2451,14
Enter the employee's date of employment (dd-MM-yyyy): 
25-05-2025
The registration date cannot be later than the date: 2023-11-07. Please enter a valid date
</pre>
**La fecha que aparece es la fecha del sistema, así que irá cambiando en función del día en que se pruebe la aplicación o se trabaje con ella**

Otro de los errores que podremos tener, es que si queremos actualizar a un empleado y agregamos un id que no existe, nos dirá que el empleado no existe 
y que deberemos buscar un empleado que exista. 
<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 3
Enter the ID of the employee to search: 25
Employee doesn´t exist
look for another employees
</pre>

Lo mismo pasaría si queremos borrar un empleado que no existe, nos saltará el mismo error:
<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 4
Enter employee ID to delete: 
25
Employee doesn´t exist
look for another employees
Employee not found..
</pre>

En el caso 5 cuando queremos buscar por cargo en la empresa y ese cargo no existe, pues también nos saltará un error de que no existe:

<pre>
Choose one of the options: 
**********************************
* 1. Enter an employee           *
* 2. List employees              *
* 3. Update employee             *
* 4. Delete employee             *
* 5. Search employee by position *
* 6. Exit                        *
**********************************
Select option: 5
Enter the position of the employee to search: 
Limpiadora
Employee doesn´t exist
look for another employees
</pre>

## Supuestos a considerar para futuras implementaciones
Esta app como tal es muy rudimentaria, ya que se podría trabajar con una interfaz gráfica
algo más amigable para el usuario.