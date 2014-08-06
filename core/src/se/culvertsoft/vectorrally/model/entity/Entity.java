/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model.entity;

import se.culvertsoft.mgen.api.model.Field;
import se.culvertsoft.mgen.javapack.metadata.FieldSetDepth;
import se.culvertsoft.mgen.javapack.metadata.FieldVisitSelection;
import se.culvertsoft.mgen.javapack.serialization.FieldVisitor;
import se.culvertsoft.mgen.javapack.serialization.Reader;
import se.culvertsoft.mgen.javapack.util.EqualityTester;
import se.culvertsoft.mgen.javapack.util.DeepCopyer;
import se.culvertsoft.mgen.javapack.util.FieldHasher;
import se.culvertsoft.mgen.javapack.util.Validator;
import se.culvertsoft.mgen.javapack.util.Marker;

public class Entity extends se.culvertsoft.vectorrally.model.MapObject {

	private se.culvertsoft.vectorrally.model.util.Vector2 m_position;

	public Entity() {
		super();
		m_position = null;
	}

	public Entity(final se.culvertsoft.vectorrally.model.util.Vector2 position) {
		m_position = position;
	}

	public se.culvertsoft.vectorrally.model.util.Vector2 getPosition() {
		return m_position;
	}

	public boolean hasPosition() {
		return _isPositionSet(FieldSetDepth.SHALLOW);
	}

	public Entity unsetPosition() {
		_setPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Entity setPosition(final se.culvertsoft.vectorrally.model.util.Vector2 position) {
		m_position = position;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = -558412147;
		result = _isPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getPosition(), _position_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Entity.class != other.getClass()) return false;
		final Entity o = (Entity)other;
		return true
		  && (_isPositionSet(FieldSetDepth.SHALLOW) == o._isPositionSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getPosition(), o.getPosition(), _position_METADATA.typ());
	}

	@Override
	public Entity deepCopy() {
		final Entity out = new Entity();
		out.setPosition(DeepCopyer.deepCopy(getPosition(), _position_METADATA.typ()));
		out._setPositionSet(_isPositionSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		return out;
	}


							
/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                    TYPE METADATA ACCESS AND SERIALIZATION METHODS                    *****
           *****          (accessed primarily by (de-)serializers and for ORM functionality)          *****	
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/	 		  
		  

	@Override
	public long _typeId() {
		return _TYPE_ID;
	}

	@Override
	public short _typeId16Bit() {
		return _TYPE_ID_16BIT;
	}

	@Override
	public String _typeId16BitBase64() {
		return _TYPE_ID_16BIT_BASE64;
	}

	@Override
	public String _typeName() {
		return _TYPE_NAME;
	}

	@Override
	public long[] _typeIds() {
		return _TYPE_IDS;
	}

	@Override
	public short[] _typeIds16Bit() {
		return _TYPE_IDS_16BIT;
	}

	@Override
	public String[] _typeIds16BitBase64() {
		return _TYPE_IDS_16BIT_BASE64;
	}

	@Override
	public String _typeIds16BitBase64String() {
		return _TYPE_IDS_16BIT_BASE64_STRING;
	}

	@Override
	public String[] _typeNames() {
		return _TYPE_NAMES;
	}

	@Override
	public void _accept(final FieldVisitor visitor, final FieldVisitSelection selection) throws java.io.IOException {
		switch(selection) {
			case ALL: {
				visitor.beginVisit(this, 1);
				visitor.visit(getPosition(), _position_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isPositionSet(FieldSetDepth.SHALLOW))
					visitor.visit(getPosition(), _position_METADATA);
				visitor.endVisit();
				break;
			}
		}
	}

	@Override
	public boolean _readField(final short fieldId,
	                         final Object context,
	                         final Reader reader) throws java.io.IOException {
		switch(fieldId) {
			case (_position_ID):
				setPosition((se.culvertsoft.vectorrally.model.util.Vector2)reader.readMgenObjectField(_position_METADATA, context));
				return true;
			default:
				reader.handleUnknownField(null, context);
				return false;
		}
	}

	@Override
	public Field[] _fields() {
		return _FIELDS;
	}

	public boolean _isPositionSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_position != null;
		} else {
			return m_position != null && Validator.validateFieldDeep(getPosition(), _position_METADATA.typ());
		}
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_position_ID):
				return _isPositionSet(depth);
			default:
				return false;
		}
	}

	public Entity _setPositionSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_position = m_position != null ? m_position : new se.culvertsoft.vectorrally.model.util.Vector2();
		else
			m_position = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getPosition(), _position_METADATA.typ());
		return this;
	}

	public Entity _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setPositionSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true
				&& (!_isPositionSet(FieldSetDepth.SHALLOW) || _isPositionSet(FieldSetDepth.DEEP));
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isPositionSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_position_ID):
				return _position_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("position"):
				return _position_METADATA;
			default:
				return null;
		}
	}


							
/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                                    TYPE METADATA                                     *****
           *****             (generally speaking, it's a bad idea to edit this manually)              *****	
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/	 		  
		  

	public static final long _TYPE_ID = 6829095988463092030L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -24990;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "nmI";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.entity.Entity";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.MapObject._TYPE_NAME, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_NAME };

	public static final Field _position_METADATA = new Field("se.culvertsoft.vectorrally.model.entity.Entity", "position", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-26337);

	public static final short _position_ID = (short)-26337;

	public static final Field[] _FIELDS = { _position_METADATA };

}
