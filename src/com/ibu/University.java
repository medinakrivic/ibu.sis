//Main class of the project
package com.ibu;

import com.ibu.DatabaseHelper.Country;

public class University {

	public static void main(String[] args) {
		Student Said = new Student();
		Said.SetName("Said");
		Said.SetSurname("Sikira");
		Said.SetBirthTown(null);
		Said.SetBirthCity("Zenica");
		Said.SetBirthCountry(Country.BiH);
		Said.SetDateOfBirth(19,3,1995);
		Said.SetCurrentAdress("Senada Poturka Senčija 76A");
		Said.SetCurrentTown("Dobrinja");
		Said.SetCurrentCity("Sarajevo");
		Said.SetCurrentCountry(Country.BiH);
		Said.SetMobile("+38762628381");
		Said.InsertIntoDatabase();
	}

}
