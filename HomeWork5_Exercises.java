import java.util.Scanner;
import java.util.Random;

public class HomeWork5_Exercises {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] myIntArray = {1, 10, 5, 25, 0, -200, 1299, 0, -77, 500};

		// (0) Print Array
		printArray(myIntArray);

		// (1) Scrieti o functie care primeste un sir de numere intregi si returneaza suma lor
		System.out.println();
		System.out.println("(1) Scrieti o functie care primeste un sir de numere intregi si returneaza suma lor");
		System.out.println("Suma sirului este: " + sumArray(myIntArray));

		// (2) Scrieti o functie care primeste un sir de numere intregi si returneaza numarul de elemente impare
		System.out.println();
		System.out.println("(2) Scrieti o functie care primeste un sir de numere intregi si returneaza numarul de elemente impare");
		System.out.println("Numarul de elemente impare este: " + numarImpareArray(myIntArray));

		// (3) Scrieti o functie care primeste un sir de numere intregi si un alt numar intreg.
		//     Returnati toate numerele mai mari decat numarul primit.
		System.out.println();
		System.out.println("(3) Scrieti o functie care primeste un sir de numere intregi si un alt numar intreg.");
		System.out.println("    Returnati toate numerele mai mari decat numarul primit.");
		
		int numar = 0;
		System.out.print("Introduceti nr. intreg: ");
		numar = scanner.nextInt();

        // Numaram cate numere sunt mai mari decat numarul dat.
        // Acest numar, nrCountNrMaiMari, va fi dimensiunea subsirului cu numere mai mari: 
        // sirul rezulat va avea la inceput nrCountNrMaiMari numere cerute, restul nu vor conta (care vor fi 0).

        int nrCountNrMaiMari = countNrMaiMariDecatUnNumar(myIntArray, numar);
        if (nrCountNrMaiMari == 0) {
            System.out.println("Nu sunt numere din sir mai mari decat numarul " + numar + ".");
        } else {
            int[] myIntArrayNrMaiMari = numereDinSirMaiMariDecatUnNumar(myIntArray, numar);
            System.out.println("Sunt " + nrCountNrMaiMari + " numere din sir mai mari decat numarul " + numar + ":");

            int nIndex = 0;
     		for (int myInt: myIntArrayNrMaiMari) {
	    		System.out.println(myInt);
	    		nIndex++;
	    		if (nIndex == nrCountNrMaiMari) {
                   break; // Exit din loop: ajuns la nr. de elemente mai mari, restul nu conteaza (nu corespund cerintei)
                }
	        }
	    }

        // (4) Scrieti o functie care primeste un numar intreg reprezentand targetul de donatii. 
        //     Donatiile se vor face cu ajutorul obiectului Random. 
        //     Primim donatii pana cand ajungem la suma dorita. 
        //     Cand ajungem la suma dorita afisam un mesaj de succes.

		System.out.println();
		System.out.println("(4) Scrieti o functie care primeste un numar intreg reprezentand targetul de donatii.");
        System.out.println("    Donatiile se vor face cu ajutorul obiectului Random.");
        System.out.println("    Primim donatii pana cand ajungem la suma dorita.");
        System.out.println("    Cand ajungem la suma dorita afisam un mesaj de succes.");

        System.out.println(strangeDonatii(1000000, 100000, true)); // Strange donatii pentru suma de 1.000.000, prin donatii de maximum 100.000

		// (5) Rescrieti functia de la 4 cu urmatoarea modificare: functia va primi si un numar maxim de donatii.
        //     Cand acesta se termina, campania se va incheia.

		System.out.println();
		System.out.println("(5) Rescrieti functia de la 4 cu urmatoarea modificare: functia va primi si un numar maxim de donatii.");
        System.out.println("    Cand acesta se termina, campania se va incheia.");

         // Strange donatii pentru suma de 1.000.000, prin donatii de maximum 100.000 si un numar de maximum 20 de donatii
         System.out.println(strangeNrMaximDonatii(1000000, 100000, 20, true));

        // (6) Scrieti o functie care primeste un string cu o fraza (mai multe propozitii despartite prin punct).
        //     Printati fiecare propozitie pe o linie noua.
		System.out.println();
        System.out.println("(6) Scrieti o functie care primeste un string cu o fraza (mai multe propozitii despartite prin punct).");
        System.out.println("    Printati fiecare propozitie pe o linie noua.");

        String fraza = "Aceasta este prima linie. Aceasta este a doua linie . Aceasta este a treia linie.Iar aceasta este a patra linie.";
		
		System.out.println();
        System.out.println("Fraza initiala este:");
        System.out.println("'" + fraza + "'");

		System.out.println();
	    scrieFrazaPeMaiMulteLinii(fraza);
	}

	// (0) printArray()
	public static void printArray(int[] intArray) { 
		int i = 0;
		System.out.println("Sirul este:");
		for (int myInt: intArray) {
			System.out.println("Sirul [" + (i++) + "] = " + myInt);
		}
	}

	// (1) sumArray()
	public static int sumArray(int[] intArray) { 
		if (intArray.length == 0) {
			return 0;
		}

		int nSuma = 0;
		for (int myInt: intArray) {
			nSuma += myInt;
		}

		return nSuma;
	}

	// (2) sumArray()
	public static int numarImpareArray(int[] intArray) { 
		if (intArray.length == 0) {
			return 0;
		}

		int numarImpare = 0;
		for (int myInt: intArray) {
			// % intoarce -1 pentru nr. negative
			// if (((myInt % 2) == 1) || ((myInt % 2) == -1)) // Putem testa in acest mod
			// Sau putem folosi functia abs() (modul)
			if (Math.abs(myInt % 2) == 1) { 
				numarImpare++;
			}
		}

		return numarImpare;
	}

    // (3) countNrMaiMariDecatUnNumar
	public static int countNrMaiMariDecatUnNumar(int[] intArray, int myIntNr) {
		if (intArray.length == 0) {
			return 0;
		}

		int nCount = 0;
		for (int myInt: intArray) {
		    if (myInt > myIntNr) {
			    nCount++;
			}
		}

	    return nCount;
    }

	// (3) numereDinSirMaiMariDecatUnNumar
	public static int[] numereDinSirMaiMariDecatUnNumar(int[] intArray, int myIntNr) {
	    int[] myIntArray = new int[intArray.length]; // declaram un sir de aceeasi dimensiune ca si originalul

		if (intArray.length > 0) {
		    int nIndex = 0;
		    for (int myInt: intArray) {
			    if (myInt > myIntNr) {
                    myIntArray[nIndex] = myInt;
			        nIndex++;
			    }
		    }
	    }

	    return myIntArray;
    }

    // (4) strangeDonatii()
	public static String strangeDonatii(int necesarDonatie, int maximDonatie, boolean afiseazaDonatiile) {
        if (necesarDonatie == 0) {
        	return "Donatia necesara a fost in valoare de 0.";
        }

        if (maximDonatie < 10) {
        	return "Minim donatie este < 10.";
        }

        Random rand = new Random();
        int sumaDonata = 0;
        int donatieCurenta = 0;
        int index = 1;
        while (sumaDonata < necesarDonatie) {
        	donatieCurenta = rand.nextInt(maximDonatie + 1); // 0 <= donatieCurenta <= maximDonatie
        	sumaDonata += donatieCurenta;
        	if (afiseazaDonatiile) {
        		System.out.println("Donatia " + (index++) + " a fost in valoare de " + donatieCurenta + ", iar suma donata pana acum este de " + sumaDonata + ".");
        	}
        }

        if (afiseazaDonatiile) {
        	System.out.println("");
            System.out.println("Pentru donatia necesara in valoare de " + necesarDonatie + " a fost stransa suma de " + sumaDonata + "." );
        }

        return "A fost stransa suma necesara.";
	}

    // (5) strangeNumarMaximDonatii()
	public static String strangeNrMaximDonatii(int necesarDonatie, int maximDonatie, int nrMaximDonatii, boolean afiseazaDonatiile) {
        if (necesarDonatie == 0) {
        	return "Donatia necesara a fost in valoare de 0.";
        }

        if (maximDonatie < 10) {
        	return "Minim donatie este < 10.";
        }

        if (nrMaximDonatii == 0) {
        	return "Nr. maxim de donatii este 0.";
        }

        Random rand = new Random();
        int sumaDonata = 0;
        int donatieCurenta = 0;
        int index = 1;
        while ((index <= nrMaximDonatii) && (sumaDonata < necesarDonatie)) {
        	donatieCurenta = rand.nextInt(maximDonatie + 1); // 0 <= donatieCurenta <= maximDonatie
        	sumaDonata += donatieCurenta;
        	if (afiseazaDonatiile) {
        		System.out.println("Donatia " + (index++) + " a fost in valoare de " + donatieCurenta + ", iar suma donata pana acum este de " + sumaDonata + ".");
        	}
        }

        if (afiseazaDonatiile) {
        	System.out.println("");
            System.out.println("Pentru donatia necesara in valoare de " + necesarDonatie + " a fost stransa suma de " + sumaDonata + "." );
            System.out.println("Nr. maxim de donatii a fost " + nrMaximDonatii + "." );
        }

        if ((index == nrMaximDonatii + 1) && (sumaDonata >= necesarDonatie)) {  // Destul de greu de sa fie amandoua conditiile simultan
        	return "A fost atins nr. maxim de donatii si a fost stransa suma necesara.";
        } else if (index == nrMaximDonatii + 1) {
        	return "A fost atins nr. maxim de donatii, dar nu a fost stransa suma necesara.";
        } else if (sumaDonata >= necesarDonatie) {
        	return "A fost stransa suma necesara printr-un nr. de donatii mai mic decat nr. maxim necesar.";
        }
        else { // Nu ar trebui sa se ajunga aci
        	return "Nu a fost stransa nici suma necesara, iar nr. de donatii este mai mic decat nr. maxim necesar.";
        }
	}

    // (6) Scrieti o functie care primeste un string cu o fraza (mai multe propozitii despartite prin punct).
    //     Printati fiecare propozitie pe o linie noua.
	public static void scrieFrazaPeMaiMulteLinii(String strFraza) { 
		if (strFraza.length() == 0) {
			return;
		}

		System.out.println("Propozitiile sunt:");
		if (strFraza.trim().contains(".")) {
			int nIndex = 0;
			String[] propozitiiDinFraza = strFraza.split("[.]");
			for (String propozitie: propozitiiDinFraza) {
				// Trebuie sa eliminam ' ' de la inceput si, eventual, de la sfarsit: folosim trim()
				// Trebuie sa adaugam '.' la sfarsit: a fost eliminat de sprit()
				System.out.println("(" + (nIndex++) + ") '" + propozitie.trim() + ".'");
			}
		}
		else {
			System.out.println("Fraza nu contine '.'");
		}
	}

 }
