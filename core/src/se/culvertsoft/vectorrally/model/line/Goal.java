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

public class Goal extends Line {

	public Goal() {
		super();
	}

	public Goal(final se.culvertsoft.vectorrally.model.util.Vector2 startPosition,
				final se.culvertsoft.vectorrally.model.util.Vector2 endPosition) {
		super(startPosition, endPosition);
	}

	public Goal unsetStartPosition() {
		_setStartPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Goal unsetEndPosition() {
		_setEndPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Goal setStartPosition(final se.culvertsoft.vectorrally.model.util.Vector2 startPosition) {
		super.setStartPosition(startPosition);
		return this;
	}

	public Goal setEndPosition(final se.culvertsoft.vectorrally.model.util.Vector2 endPosition) {
		super.setEndPosition(endPosition);
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = -833778036;
		result = _isStartPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getStartPosition(), _startPosition_METADATA.typ())) : result;
		result = _isEndPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getEndPosition(), _endPosition_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Goal.class != other.getClass()) return false;
		final Goal o = (Goal)other;
		return true
		  && (_isStartPositionSet(FieldSetDepth.SHALLOW) == o._isStartPositionSet(FieldSetDepth.SHALLOW))
		  && (_isEndPositionSet(FieldSetDepth.SHALLOW) == o._isEndPositionSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getStartPosition(), o.getStartPosition(), _startPosition_METADATA.typ())
		  && EqualityTester.areEqual(getEndPosition(), o.getEndPosition(), _endPosition_METADATA.typ());
	}

	@Override
	public Goal deepCopy() {
		final Goal out = new Goal();
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

	public Goal _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
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
		  

	public static final long _TYPE_ID = 3080967789489705218L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID, se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -7467;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "4tU";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.line.Goal";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.MapObject._TYPE_NAME, se.culvertsoft.vectorrally.model.line.Line._TYPE_NAME, se.culvertsoft.vectorrally.model.line.Goal._TYPE_NAME };

	public static final Field _startPosition_METADATA = new Field("se.culvertsoft.vectorrally.model.line.Goal", "startPosition", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-9135);
	public static final Field _endPosition_METADATA = new Field("se.culvertsoft.vectorrally.model.line.Goal", "endPosition", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)30414);

	public static final short _startPosition_ID = (short)-9135;
	public static final short _endPosition_ID = (short)30414;

	public static final Field[] _FIELDS = { _startPosition_METADATA, _endPosition_METADATA };

}
