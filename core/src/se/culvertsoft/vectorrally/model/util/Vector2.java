/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model.util;

import se.culvertsoft.mgen.api.model.Field;
import se.culvertsoft.mgen.javapack.metadata.FieldSetDepth;
import se.culvertsoft.mgen.javapack.metadata.FieldVisitSelection;
import se.culvertsoft.mgen.javapack.serialization.FieldVisitor;
import se.culvertsoft.mgen.javapack.serialization.Reader;
import se.culvertsoft.mgen.javapack.util.EqualityTester;
import se.culvertsoft.mgen.javapack.util.DeepCopyer;
import se.culvertsoft.mgen.javapack.util.FieldHasher;

public class Vector2 extends se.culvertsoft.mgen.javapack.classes.MGenBase {

	private int m_x;
	private int m_y;
	private boolean _m_x_isSet;
	private boolean _m_y_isSet;

	public Vector2() {
		super();
		m_x = 0;
		m_y = 0;
		_m_x_isSet = false;
		_m_y_isSet = false;
	}

	public Vector2(final int x,
				final int y) {
		m_x = x;
		m_y = y;
		_m_x_isSet = true;
		_m_y_isSet = true;
	}

	public int getX() {
		return m_x;
	}

	public int getY() {
		return m_y;
	}

	public boolean hasX() {
		return _isXSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasY() {
		return _isYSet(FieldSetDepth.SHALLOW);
	}

	public Vector2 unsetX() {
		_setXSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Vector2 unsetY() {
		_setYSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Vector2 setX(final int x) {
		m_x = x;
		_m_x_isSet = true;
		return this;
	}

	public Vector2 setY(final int y) {
		m_y = y;
		_m_y_isSet = true;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = -1351603388;
		result = _isXSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getX(), _x_METADATA.typ())) : result;
		result = _isYSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getY(), _y_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Vector2.class != other.getClass()) return false;
		final Vector2 o = (Vector2)other;
		return true
		  && (_isXSet(FieldSetDepth.SHALLOW) == o._isXSet(FieldSetDepth.SHALLOW))
		  && (_isYSet(FieldSetDepth.SHALLOW) == o._isYSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getX(), o.getX(), _x_METADATA.typ())
		  && EqualityTester.areEqual(getY(), o.getY(), _y_METADATA.typ());
	}

	@Override
	public Vector2 deepCopy() {
		final Vector2 out = new Vector2();
		out.setX(DeepCopyer.deepCopy(getX(), _x_METADATA.typ()));
		out.setY(DeepCopyer.deepCopy(getY(), _y_METADATA.typ()));
		out._setXSet(_isXSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setYSet(_isYSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
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
				visitor.beginVisit(this, 2);
				visitor.visit(getX(), _x_METADATA);
				visitor.visit(getY(), _y_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isXSet(FieldSetDepth.SHALLOW))
					visitor.visit(getX(), _x_METADATA);
				if (_isYSet(FieldSetDepth.SHALLOW))
					visitor.visit(getY(), _y_METADATA);
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
			case (_x_ID):
				setX((int)reader.readInt32Field(_x_METADATA, context));
				return true;
			case (_y_ID):
				setY((int)reader.readInt32Field(_y_METADATA, context));
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

	public boolean _isXSet(final FieldSetDepth fieldSetDepth) {
		return _m_x_isSet;
	}

	public boolean _isYSet(final FieldSetDepth fieldSetDepth) {
		return _m_y_isSet;
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_x_ID):
				return _isXSet(depth);
			case (_y_ID):
				return _isYSet(depth);
			default:
				return false;
		}
	}

	public Vector2 _setXSet(final boolean state, final FieldSetDepth depth) {
		if (!state)
			m_x = 0;
		_m_x_isSet = state;
		return this;
	}

	public Vector2 _setYSet(final boolean state, final FieldSetDepth depth) {
		if (!state)
			m_y = 0;
		_m_y_isSet = state;
		return this;
	}

	public Vector2 _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setXSet(state, depth);
		_setYSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true;
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isXSet(depth) ? 1 : 0;
		out += _isYSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_x_ID):
				return _x_METADATA;
			case (_y_ID):
				return _y_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("x"):
				return _x_METADATA;
			case ("y"):
				return _y_METADATA;
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
		  

	public static final long _TYPE_ID = 2411142272178246518L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -18662;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "txo";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.util.Vector2";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.util.Vector2._TYPE_NAME };

	public static final Field _x_METADATA = new Field("se.culvertsoft.vectorrally.model.util.Vector2", "x", se.culvertsoft.mgen.api.model.Int32Type.INSTANCE, null, (short)7791);
	public static final Field _y_METADATA = new Field("se.culvertsoft.vectorrally.model.util.Vector2", "y", se.culvertsoft.mgen.api.model.Int32Type.INSTANCE, null, (short)3662);

	public static final short _x_ID = (short)7791;
	public static final short _y_ID = (short)3662;

	public static final Field[] _FIELDS = { _x_METADATA, _y_METADATA };

}
