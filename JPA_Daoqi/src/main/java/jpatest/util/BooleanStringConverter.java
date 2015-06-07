package jpatest.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=false)
public class BooleanStringConverter implements
		AttributeConverter<Boolean, String> {

	// Converts the value stored in the entity attribute into the data
	// representation to be stored in the database.
	public String convertToDatabaseColumn(Boolean value) {
		if (value != null && value) {
			return "T";
		} else {
			return "F";
		}
	}

	// Converts the data stored in the database column into the value to be
	// stored in the entity attribute.
	public Boolean convertToEntityAttribute(String value) {
		return "T".equals(value);
	}

}
