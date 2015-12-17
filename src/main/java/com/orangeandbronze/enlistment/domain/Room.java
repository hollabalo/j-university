package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

public class Room {

	private final String name;
	private final Integer capacity;

	public Room(String name, Integer capacity) {
		notBlank(name);
		notNull(capacity);
		if (!name.matches("[-\\p{Alnum}]+")) {
			throw new IllegalArgumentException("name is not alphanumeric");
		}
		this.name = name;
		this.capacity = capacity;
	}

	public Integer getCapacity() {
		return capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " (" + capacity + " seats max)";
	}

}
