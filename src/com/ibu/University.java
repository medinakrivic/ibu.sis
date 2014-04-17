//Main class of the project
package com.ibu;

import com.ibu.crud.*;

public class University {

	public static void main(String[] args) {
		CRUD crud = new CRUD();
		if (!crud.UpdateStates(6, "Canada"))
		{
			System.err.println("error");
		}
	}

}
