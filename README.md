# ISA Projekat - SkillSwap & Upravljanje Korisnicima

Ovaj projekat radio se na predmetu *Internet Softverske Arhitekture* (ISA), a sastoji se od Spring Boot bekenda i Next.js frontenda.

## Arhitektura Projekta
* **Backend:** Spring Boot (Java 21), Spring Security sa JWT autentifikacijom, Spring Data JPA, MySQL baza podataka (`isa26`).
* **Frontend:** Next.js, Bootstrap, Tailwind CSS.

## Glavne Funkcionalnosti
* Autentifikacija i autorizacija korisnika uz pomoć JWT tokena i uloga (`ROLE_ADMIN`, `ROLE_USER`).
* Upravljanje i pregled lista korisnika i njihovih veština.
* Paginacija i validacija podataka na nivou API-ja.

## Pokretanje Projekta

### 1. Pokretanje Bekenda (Spring Boot)
1. Podesite parametre baze podataka u `application.properties` fajlu (baza `isa26`).
2. Pokrenite aplikaciju preko Vašeg IDE-a (IntelliJ IDEA) pokretanjem `IsaApplication.java` fajla ili putem terminala:
   ```bash
   mvn spring-boot:run

### 2.Pokretanje Frontenda (Next.js)
Pozicionirajte se u folder sa frontend delom projekta u terminalu.

Instalirajte zavisnosti (ukoliko već niste):
npm install

Pokrenite razvojni server:
npm run dev

Frontend će biti dostupan na adresi http://localhost:3000.
