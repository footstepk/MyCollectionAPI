package models;

import java.util.Objects;
import utils.Console;

/**
 * Class Person represents a notion of a person,
 * its instance acts as a model
 * @author KokHeng
 *
 */

public class Person {

	/** Data global fields. */

	// a person unique id number
	private final int id;
	// a person full name
	private String name;
	// a person phone number
	private String phone;
	// a person home address
	private String address;

	private Person(int ids) {
		id = ids;
	}

	private Person(int ids, String names, String phones, String addresses) {
		id = ids;
		name = names;
		phone = phones;
		address = addresses;
	}

	private Person(String names, String phones, String addresses) {
		id = Console.generateId(6);
		name = names;
		phone = phones;
		address = addresses;
	}

	public static Person getPerson(int ids) {
		return new Person(ids);
	}

	public static Person getPerson(int ids, String names, String phones, String addresses) {
	return new Person(ids, names, phones, addresses);
}

	public static Person getPerson(String names, String phones, String addresses) {
		return new Person(names, phones, addresses);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Person id: " + id + "\n" +
				"Person Name: " + name + "\n" +
				"Phone Number: " + phone + "\n" +
				"Address: " + address + "\n");
		return result.toString();
	}

	@Override
public boolean equals(Object obj) {
	if(obj == null) return false;
	Person p = (Person) obj;
	return  id == p.id ||
			name.equals(p.name) ||
			phone.equals(p.phone) ||
			address.equals(p.address);
}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phone, address);
	}
}
