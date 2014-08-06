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

public class Game extends se.culvertsoft.mgen.javapack.classes.MGenBase {

	private int m_Players;
	private Map m_map;
	private boolean _m_Players_isSet;

	public Game() {
		super();
		m_Players = 0;
		m_map = null;
		_m_Players_isSet = false;
	}

	public Game(final int Players,
				final Map map) {
		m_Players = Players;
		m_map = map;
		_m_Players_isSet = true;
	}

	public int getPlayers() {
		return m_Players;
	}

	public Map getMap() {
		return m_map;
	}

	public boolean hasPlayers() {
		return _isPlayersSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasMap() {
		return _isMapSet(FieldSetDepth.SHALLOW);
	}

	public Game unsetPlayers() {
		_setPlayersSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Game unsetMap() {
		_setMapSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Game setPlayers(final int Players) {
		m_Players = Players;
		_m_Players_isSet = true;
		return this;
	}

	public Game setMap(final Map map) {
		m_map = map;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 488357651;
		result = _isPlayersSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getPlayers(), _Players_METADATA.typ())) : result;
		result = _isMapSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getMap(), _map_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Game.class != other.getClass()) return false;
		final Game o = (Game)other;
		return true
		  && (_isPlayersSet(FieldSetDepth.SHALLOW) == o._isPlayersSet(FieldSetDepth.SHALLOW))
		  && (_isMapSet(FieldSetDepth.SHALLOW) == o._isMapSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getPlayers(), o.getPlayers(), _Players_METADATA.typ())
		  && EqualityTester.areEqual(getMap(), o.getMap(), _map_METADATA.typ());
	}

	@Override
	public Game deepCopy() {
		final Game out = new Game();
		out.setPlayers(DeepCopyer.deepCopy(getPlayers(), _Players_METADATA.typ()));
		out.setMap(DeepCopyer.deepCopy(getMap(), _map_METADATA.typ()));
		out._setPlayersSet(_isPlayersSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setMapSet(_isMapSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
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
				visitor.visit(getPlayers(), _Players_METADATA);
				visitor.visit(getMap(), _map_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isPlayersSet(FieldSetDepth.SHALLOW))
					visitor.visit(getPlayers(), _Players_METADATA);
				if (_isMapSet(FieldSetDepth.SHALLOW))
					visitor.visit(getMap(), _map_METADATA);
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
			case (_Players_ID):
				setPlayers((int)reader.readInt32Field(_Players_METADATA, context));
				return true;
			case (_map_ID):
				setMap((Map)reader.readMgenObjectField(_map_METADATA, context));
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

	public boolean _isPlayersSet(final FieldSetDepth fieldSetDepth) {
		return _m_Players_isSet;
	}

	public boolean _isMapSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_map != null;
		} else {
			return m_map != null && Validator.validateFieldDeep(getMap(), _map_METADATA.typ());
		}
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_Players_ID):
				return _isPlayersSet(depth);
			case (_map_ID):
				return _isMapSet(depth);
			default:
				return false;
		}
	}

	public Game _setPlayersSet(final boolean state, final FieldSetDepth depth) {
		if (!state)
			m_Players = 0;
		_m_Players_isSet = state;
		return this;
	}

	public Game _setMapSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_map = m_map != null ? m_map : new Map();
		else
			m_map = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getMap(), _map_METADATA.typ());
		return this;
	}

	public Game _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setPlayersSet(state, depth);
		_setMapSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true
				&& (!_isMapSet(FieldSetDepth.SHALLOW) || _isMapSet(FieldSetDepth.DEEP));
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isPlayersSet(depth) ? 1 : 0;
		out += _isMapSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_Players_ID):
				return _Players_METADATA;
			case (_map_ID):
				return _map_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("Players"):
				return _Players_METADATA;
			case ("map"):
				return _map_METADATA;
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
		  

	public static final long _TYPE_ID = 3993833445368397183L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.Game._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -29852;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "i2Q";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.Game";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.Game._TYPE_NAME };

	public static final Field _Players_METADATA = new Field("se.culvertsoft.vectorrally.model.Game", "Players", se.culvertsoft.mgen.api.model.Int32Type.INSTANCE, null, (short)7545);
	public static final Field _map_METADATA = new Field("se.culvertsoft.vectorrally.model.Game", "map", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.Map", 4343410752178357644L), null, (short)21290);

	public static final short _Players_ID = (short)7545;
	public static final short _map_ID = (short)21290;

	public static final Field[] _FIELDS = { _Players_METADATA, _map_METADATA };

}
