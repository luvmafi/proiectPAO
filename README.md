# ProiectPAO

ProiectPAO este o aplicație Java care gestionează pacienți, medici, facturi, rețete și istoricul medical într-un cabinet medical.

## Structura proiectului

Proiectul este structurat în mai multe pachete:

- `model`: Conține clasele de model pentru Pacient, Medic, Factura, Reteta și IstoricMedical.
- `service`: Conține serviciile care manipulează modelele și interacționează cu pachetul `daoservices`.
- `dao`: Conține interfețele DAO pentru Factura, IstoricMedical și Reteta.
- `dao.impl`: Conține implementările interfețelor DAO.
- `daoservices`: Conține serviciile care interacționează direct cu DAOs.
- `daoservices.impl`: Conține implementările serviciilor DAO.

## Funcționalități

Aplicația oferă următoarele funcționalități:

- Adăugarea de pacienți și medici.
- Crearea de facturi pentru pacienți.
- Adăugarea de istoric medical pentru pacienți.
- Crearea de rețete pentru pacienți.
- Afișarea tuturor facturilor.
- Afișarea rețetei unui pacient după ID.
- Afișarea istoricului medical al unui pacient.
- Ștergerea facturilor, istoricului medical și rețetelor după ID.

## Cum să rulezi

Pentru a rula aplicația, deschideți `src/Main.java` și executați metoda `main` apoi urmăriți indicațiile din consolă.
