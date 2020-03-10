// ConsoleApplication1.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include "pch.h"
#include <iostream>
#include <ctype.h>

void konwersja1(char * t);
void konwersja2(char * t);
void konwersja3(char * t);
unsigned mnozenie(unsigned x, unsigned y);

int main()
{
	/*char text[50];
	printf("Podaj napis");
	printf("\n");
	fgets(text, sizeof text, stdin);

	konwersja1(text);
	printf(text);
	konwersja2(text);
	printf(text);
	konwersja3(text);
	printf(text);*/

	//liczby do mnozenia
	unsigned x = 3;
	unsigned y = 10;
	/*printf("Podaj pierwsza liczbe:");
	printf("\n");
	scanf("%d", &x);

	printf("Podaj drugaliczbe:");
	printf("\n");
	scanf("%d", &y);*/

	unsigned iloczyn = mnozenie(x, y);

	printf("wynik mnozenia przez operacje przesuniecia bitowego:");
	printf("\n");
	printf("%u",iloczyn);

	//tworzenie loginu dla uzytkownika - zadanie do domu 

	return 0;

}

void konwersja1(char *t) {
	//male litery na wielkie
	//AND i negacja maski
	
	while (*t) {
		if (*t >= 'a' && *t <= 'z')
			*t = *t & 0b11011111;
		t++;
	}

	/*for  (int i = 0; i <strlen(t) ; i++)
	{
		if(isalpha(t[i])==true)
		t[i] = ~maska & t[i];
	}*/
}


void konwersja2(char *t) {
	//wielkie litery na male
	//OR i maska

	while (*t) {
		if (*t >= 'A' && *t <= 'Z')
			*t = *t | 0b00100000;
		t++;
	}

	/*for (int i = 0; i < strlen(t); i++)
	{
		if (isalpha(t[i]) == true)
		t[i] = maska | t[i];
	}*/
}


void konwersja3(char *t) {
	//male litery na wielkie, wielkie na male

	while (*t) {
		if ((*t >= 'a' && *t <= 'z') || (*t >= 'A' && *t <= 'Z'))
			*t = *t ^ 0b00100000;
		t++;
	}

	/*for (int i = 0; i < strlen(t); i++)
	{
		if (isalpha(t[i]) == true)
		t[i] = maska ^ t[i];
	}*/
}

unsigned mnozenie(unsigned x, unsigned y) {
	
	unsigned wynik = 0;
	while (y) {
		if (y & 1) {
			wynik += x;
		}
		x <<= 1; // pomnoz przez 2
		y >>= 1; // podziel przez 2
	}
	return wynik;
}
