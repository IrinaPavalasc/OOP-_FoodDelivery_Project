Clase:
-Person(clasa abstracta) 

-Address

-Card

-User(mostenita din Person si compusa din Address si Card)

-Driver(mostenita din Person)

-Product(clasa abstracta)

-Food(mostenita din Product)

-Drink(mostenita din Product)

-Restaurant(compusa din Food si Drink)

-Order(compusa din User, Driver, Restaurant)

-serviceUser

---------------------------------Actions----------------------------------
======================================================================================
1. Add restaurants.
2. Add foods to a restaurant.
3. Add drinks to a restaurant.
4. Add drivers.
5. Register users.
6. Login user.
7. Edit current user.
8. Show all local restaurants and place order.
9. Show all local drivers.
10. Show all current user's orders.
11. Show current user info.
12. Show all restaurants.
0. Exit.
Type the option number: 

5 -"Inregistrarea" este necesara pentru logare

6 -Logarea este necesara pentru a accesa actiunile 7,8,9,10,11 (deoarece acestea necesita informatiile utilizatorului curent)

****Restaurantele sunt sortate dupa categoria din care fac parte de fiecare data cand se adauga un nou restaurant

****Restaurantele contin un "FoodMeniu"- HashMap in care cheia este categoria obiectului "Food", iar valoarea este o listaa de obiecte "Food"

*Functiile resgisterUser, registerDrivers, placeOrder, addDrink, addFood,registerRestaurants au fost comentate deoarece sunt incorporate in meniu
