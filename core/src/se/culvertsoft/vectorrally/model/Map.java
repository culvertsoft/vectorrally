/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model;

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

public class Map extends se.culvertsoft.mgen.javapack.classes.MGenBase {

	private int m_Width;
	private int m_Height;
	private java.util.ArrayList<MapObject> m_objects;
	private boolean _m_Width_isSet;
	private boolean _m_Height_isSet;

	public Map() {
		super();
		m_Width = 0;
		m_Height = 0;
		m_objects = null;
		_m_Width_isSet = false;
		_m_Height_isSet = false;
	}

	public Map(final int Width,
				final int Height,
				final java.util.ArrayList<MapObject> objects) {
		m_Width = Width;
		m_Height = Height;
		m_objects = objects;
		_m_Width_isSet = true;
		_m_Height_isSet = true;
	}

	public int getWidth() {
		return m_Width;
	}

	public int getHeight() {
		return m_Height;
	}

	public java.util.ArrayList<MapObject> getObjects() {
		return m_objects;
	}

	public boolean hasWidth() {
		return _isWidthSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasHeight() {
		return _isHeightSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasObjects() {
		return _isObjectsSet(FieldSetDepth.SHALLOW);
	}

	public Map unsetWidth() {
		_setWidthSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Map unsetHeight() {
		_setHeightSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Map unsetObjects() {
		_setObjectsSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Map setWidth(final int Width) {
		m_Width = Width;
		_m_Width_isSet = true;
		return this;
	}

	public Map setHeight(final int Height) {
		m_Height = Height;
		_m_Height_isSet = true;
		return this;
	}

	public Map setObjects(final java.util.ArrayList<MapObject> objects) {
		m_objects = objects;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 708495899;
		result = _isWidthSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getWidth(), _Width_METADATA.typ())) : result;
		result = _isHeightSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getHeight(), _Height_METADATA.typ())) : result;
		result = _isObjectsSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getObjects(), _objects_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Map.class != other.getClass()) return false;
		final Map o = (Map)other;
		return true
		  && (_isWidthSet(FieldSetDepth.SHALLOW) == o._isWidthSet(FieldSetDepth.SHALLOW))
		  && (_isHeightSet(FieldSetDepth.SHALLOW) == o._isHeightSet(FieldSetDepth.SHALLOW))
		  && (_isObjectsSet(FieldSetDepth.SHALLOW) == o._isObjectsSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getWidth(), o.getWidth(), _Width_METADATA.typ())
		  && EqualityTester.areEqual(getHeight(), o.getHeight(), _Height_METADATA.typ())
		  && EqualityTester.areEqual(getObjects(), o.getObjects(), _objects_METADATA.typ());
	}

	@Override
	public Map deepCopy() {
		final Map out = new Map();
		out.setWidth(DeepCopyer.deepCopy(getWidth(), _Width_METADATA.typ()));
		out.setHeight(DeepCopyer.deepCopy(getHeight(), _Height_METADATA.typ()));
		out.setObjects(DeepCopyer.deepCopy(getObjects(), _objects_METADATA.typ()));
		out._setWidthSet(_isWidthSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setHeightSet(_isHeightSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setObjectsSet(_isObjectsSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
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
				visitor.beginVisit(this, 3);
				visitor.visit(getWidth(), _Width_METADATA);
				visitor.visit(getHeight(), _Height_METADATA);
				visitor.visit(getObjects(), _objects_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isWidthSet(FieldSetDepth.SHALLOW))
					visitor.visit(getWidth(), _Width_METADATA);
				if (_isHeightSet(FieldSetDepth.SHALLOW))
					visitor.visit(getHeight(), _Height_METADATA);
				if (_isObjectsSet(FieldSetDepth.SHALLOW))
					visitor.visit(getObjects(), _objects_METADATA);
				visitor.endVisit();
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean _readField(final short fieldId,
	                         final Object context,
	                         final Reader reader) throws java.io.IOException {
		switch(fieldId) {
			case (_Width_ID):
				setWidth((int)reader.readInt32Field(_Width_METADATA, context));
				return true;
			case (_Height_ID):
				setHeight((int)reader.readInt32Field(_Height_METADATA, context));
				return true;
			case (_objects_ID):
				setObjects((java.util.ArrayList<MapObject>)reader.readListField(_objects_METADATA, context));
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

	public boolean _isWidthSet(final FieldSetDepth fieldSetDepth) {
		return _m_Width_isSet;
	}

	public boolean _isHeightSet(final FieldSetDepth fieldSetDepth) {
		return _m_Height_isSet;
	}

	public boolean _isObjectsSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_objects != null;
		} else {
			return m_objects != null && Validator.validateFieldDeep(getObjects(), _objects_METADATA.typ());
		}
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_Width_ID):
				return _isWidthSet(depth);
			case (_Height_ID):
				return _isHeightSet(depth);
			case (_objects_ID):
				return _isObjectsSet(depth);
			default:
				return false;
		}
	}

	public Map _setWidthSet(final boolean state, final FieldSetDepth depth) {
		if (!state)
			m_Width = 0;
		_m_Width_isSet = state;
		return this;
	}

	public Map _setHeightSet(final boolean state, final FieldSetDepth depth) {
		if (!state)
			m_Height = 0;
		_m_Height_isSet = state;
		return this;
	}

	public Map _setObjectsSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_objects = m_objects != null ? m_objects : new java.util.ArrayList<MapObject>();
		else
			m_objects = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getObjects(), _objects_METADATA.typ());
		return this;
	}

	public Map _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setWidthSet(state, depth);
		_setHeightSet(state, depth);
		_setObjectsSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true
				&& (!_isObjectsSet(FieldSetDepth.SHALLOW) || _isObjectsSet(FieldSetDepth.DEEP));
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isWidthSet(depth) ? 1 : 0;
		out += _isHeightSet(depth) ? 1 : 0;
		out += _isObjectsSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_Width_ID):
				return _Width_METADATA;
			case (_Height_ID):
				return _Height_METADATA;
			case (_objects_ID):
				return _objects_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("Width"):
				return _Width_METADATA;
			case ("Height"):
				return _Height_METADATA;
			case ("objects"):
				return _objects_METADATA;
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
		  

	public static final long _TYPE_ID = 4343410752178357644L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.Map._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -29814;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "i4o";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.Map";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.Map._TYPE_NAME };

	public static final Field _Width_METADATA = new Field("se.culvertsoft.vectorrally.model.Map", "Width", se.culvertsoft.mgen.api.model.Int32Type.INSTANCE, null, (short)-22569);
	public static final Field _Height_METADATA = new Field("se.culvertsoft.vectorrally.model.Map", "Height", se.culvertsoft.mgen.api.model.Int32Type.INSTANCE, null, (short)23303);
	public static final Field _objects_METADATA = new Field("se.culvertsoft.vectorrally.model.Map", "objects", new se.culvertsoft.mgen.api.model.ListType(new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.MapObject", 2054525997235029554L)), null, (short)-4398);

	public static final short _Width_ID = (short)-22569;
	public static final short _Height_ID = (short)23303;
	public static final short _objects_ID = (short)-4398;

	public static final Field[] _FIELDS = { _Width_METADATA, _Height_METADATA, _objects_METADATA };

}
