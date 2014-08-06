/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model.line;

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

public class Line extends se.culvertsoft.vectorrally.model.MapObject {

	private se.culvertsoft.vectorrally.model.util.Vector2 m_startPosition;
	private se.culvertsoft.vectorrally.model.util.Vector2 m_endPosition;

	public Line() {
		super();
		m_startPosition = null;
		m_endPosition = null;
	}

	public Line(final se.culvertsoft.vectorrally.model.util.Vector2 startPosition,
				final se.culvertsoft.vectorrally.model.util.Vector2 endPosition) {
		m_startPosition = startPosition;
		m_endPosition = endPosition;
	}

	public se.culvertsoft.vectorrally.model.util.Vector2 getStartPosition() {
		return m_startPosition;
	}

	public se.culvertsoft.vectorrally.model.util.Vector2 getEndPosition() {
		return m_endPosition;
	}

	public boolean hasStartPosition() {
		return _isStartPositionSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasEndPosition() {
		return _isEndPositionSet(FieldSetDepth.SHALLOW);
	}

	public Line unsetStartPosition() {
		_setStartPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Line unsetEndPosition() {
		_setEndPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Line setStartPosition(final se.culvertsoft.vectorrally.model.util.Vector2 startPosition) {
		m_startPosition = startPosition;
		return this;
	}

	public Line setEndPosition(final se.culvertsoft.vectorrally.model.util.Vector2 endPosition) {
		m_endPosition = endPosition;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = -833634451;
		result = _isStartPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getStartPosition(), _startPosition_METADATA.typ())) : result;
		result = _isEndPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getEndPosition(), _endPosition_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Line.class != other.getClass()) return false;
		final Line o = (Line)other;
		return true
		  && (_isStartPositionSet(FieldSetDepth.SHALLOW) == o._isStartPositionSet(FieldSetDepth.SHALLOW))
		  && (_isEndPositionSet(FieldSetDepth.SHALLOW) == o._isEndPositionSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getStartPosition(), o.getStartPosition(), _startPosition_METADATA.typ())
		  && EqualityTester.areEqual(getEndPosition(), o.getEndPosition(), _endPosition_METADATA.typ());
	}

	@Override
	public Line deepCopy() {
		final Line out = new Line();
		out.setStartPosition(DeepCopyer.deepCopy(getStartPosition(), _startPosition_METADATA.typ()));
		out.setEndPosition(DeepCopyer.deepCopy(getEndPosition(), _endPosition_METADATA.typ()));
		out._setStartPositionSet(_isStartPositionSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setEndPositionSet(_isEndPositionSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
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
				visitor.visit(getStartPosition(), _startPosition_METADATA);
				visitor.visit(getEndPosition(), _endPosition_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isStartPositionSet(FieldSetDepth.SHALLOW))
					visitor.visit(getStartPosition(), _startPosition_METADATA);
				if (_isEndPositionSet(FieldSetDepth.SHALLOW))
					visitor.visit(getEndPosition(), _endPosition_METADATA);
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
			case (_startPosition_ID):
				setStartPosition((se.culvertsoft.vectorrally.model.util.Vector2)reader.readMgenObjectField(_startPosition_METADATA, context));
				return true;
			case (_endPosition_ID):
				setEndPosition((se.culvertsoft.vectorrally.model.util.Vector2)reader.readMgenObjectField(_endPosition_METADATA, context));
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

	public boolean _isStartPositionSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_startPosition != null;
		} else {
			return m_startPosition != null && Validator.validateFieldDeep(getStartPosition(), _startPosition_METADATA.typ());
		}
	}

	public boolean _isEndPositionSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_endPosition != null;
		} else {
			return m_endPosition != null && Validator.validateFieldDeep(getEndPosition(), _endPosition_METADATA.typ());
		}
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_startPosition_ID):
				return _isStartPositionSet(depth);
			case (_endPosition_ID):
				return _isEndPositionSet(depth);
			default:
				return false;
		}
	}

	public Line _setStartPositionSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_startPosition = m_startPosition != null ? m_startPosition : new se.culvertsoft.vectorrally.model.util.Vector2();
		else
			m_startPosition = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getStartPosition(), _startPosition_METADATA.typ());
		return this;
	}

	public Line _setEndPositionSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_endPosition = m_endPosition != null ? m_endPosition : new se.culvertsoft.vectorrally.model.util.Vector2();
		else
			m_endPosition = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getEndPosition(), _endPosition_METADATA.typ());
		return this;
	}

	public Line _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setStartPositionSet(state, depth);
		_setEndPositionSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true
				&& (!_isStartPositionSet(FieldSetDepth.SHALLOW) || _isStartPositionSet(FieldSetDepth.DEEP))
				&& (!_isEndPositionSet(FieldSetDepth.SHALLOW) || _isEndPositionSet(FieldSetDepth.DEEP));
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isStartPositionSet(depth) ? 1 : 0;
		out += _isEndPositionSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_startPosition_ID):
				return _startPosition_METADATA;
			case (_endPosition_ID):
				return _endPosition_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("startPosition"):
				return _startPosition_METADATA;
			case ("endPosition"):
				return _endPosition_METADATA;
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
		  

	public static final long _TYPE_ID = 5426693121306130889L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -12419;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "z30";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.line.Line";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.MapObject._TYPE_NAME, se.culvertsoft.vectorrally.model.line.Line._TYPE_NAME };

	public static final Field _startPosition_METADATA = new Field("se.culvertsoft.vectorrally.model.line.Line", "startPosition", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-9135);
	public static final Field _endPosition_METADATA = new Field("se.culvertsoft.vectorrally.model.line.Line", "endPosition", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)30414);

	public static final short _startPosition_ID = (short)-9135;
	public static final short _endPosition_ID = (short)30414;

	public static final Field[] _FIELDS = { _startPosition_METADATA, _endPosition_METADATA };

}
