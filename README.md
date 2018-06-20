***UPUTSTVO ZA INSTALACIJU I POKRETANJE PROJEKTA***

1. Neophodno je prethodno skinuti projekat sa git repozitorijuma koji je dostupan na linku: https://github.com/markomucalov/ISA-MRS-TIM7.

2. Nije neophodna instalacija dodatnih biblioteka, sve biblioteke su dostupne zajedno sa projektom na gore pomenutom repozitorijumu.
   Takodje, bibloteke su na ispravan nacin ukljucene u rad projekta, tako da dodatna podesavanja nisu neophodna.
   
3. Projekat se pokrece iz razvojnog okruzenja koje podrzava rad sa Maven projektima. Preporucuje se pokretanje iz razvojnog okruzenja Eclipse,
   iz razloga sto je projekat razvijan u pomenutom okruzenju.
   
4. U Eclipse okruzenju projekat se importuje na sledeci nacin:
		- Odabere se radni prostor za Eclipse (workspace).
		- Uveze se projekat komandom: File->Import->Existing Maven Projects
		- Odabere se projekat sa lokacije na disku

5. Projekat se pokrece iz Eclipse-a komandom Run As -> Spring Boot Application

6. Kada je server pokrenut u zeljenom pretrazivacu (Opera, Chrome, Microsoft Edge) uneti adresu servera i port: http://localhost:8080

7. Prikazuje se pocetna strana aplikacije i korisnik moze dalje da je koristi.