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

public class Car extends Entity {

	private String m_player;
	private se.culvertsoft.vectorrally.model.util.Vector2 m_currentVelocity;
	private se.culvertsoft.vectorrally.model.util.Vector2 m_wantedPosition;

	public Car() {
		super();
		m_player = null;
		m_currentVelocity = null;
		m_wantedPosition = null;
	}

	public Car(final se.culvertsoft.vectorrally.model.util.Vector2 position,
				final String player,
				final se.culvertsoft.vectorrally.model.util.Vector2 currentVelocity,
				final se.culvertsoft.vectorrally.model.util.Vector2 wantedPosition) {
		super(position);
		m_player = player;
		m_currentVelocity = currentVelocity;
		m_wantedPosition = wantedPosition;
	}

	public String getPlayer() {
		return m_player;
	}

	public se.culvertsoft.vectorrally.model.util.Vector2 getCurrentVelocity() {
		return m_currentVelocity;
	}

	public se.culvertsoft.vectorrally.model.util.Vector2 getWantedPosition() {
		return m_wantedPosition;
	}

	public boolean hasPlayer() {
		return _isPlayerSet(FieldSetDepth.SHALLOW);
	}

	public boolean hasCurrentVelocity() {
		return _isCurrentVelocitySet(FieldSetDepth.SHALLOW);
	}

	public boolean hasWantedPosition() {
		return _isWantedPositionSet(FieldSetDepth.SHALLOW);
	}

	public Car unsetPosition() {
		_setPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Car unsetPlayer() {
		_setPlayerSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Car unsetCurrentVelocity() {
		_setCurrentVelocitySet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Car unsetWantedPosition() {
		_setWantedPositionSet(false, FieldSetDepth.SHALLOW);
		return this;
	}

	public Car setPosition(final se.culvertsoft.vectorrally.model.util.Vector2 position) {
		super.setPosition(position);
		return this;
	}

	public Car setPlayer(final String player) {
		m_player = player;
		return this;
	}

	public Car setCurrentVelocity(final se.culvertsoft.vectorrally.model.util.Vector2 currentVelocity) {
		m_currentVelocity = currentVelocity;
		return this;
	}

	public Car setWantedPosition(final se.culvertsoft.vectorrally.model.util.Vector2 wantedPosition) {
		m_wantedPosition = wantedPosition;
		return this;
	}

	@Override
	public String toString() {
		return se.culvertsoft.mgen.javapack.util.Stringifyer.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = -273799830;
		result = _isPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getPosition(), _position_METADATA.typ())) : result;
		result = _isPlayerSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getPlayer(), _player_METADATA.typ())) : result;
		result = _isCurrentVelocitySet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getCurrentVelocity(), _currentVelocity_METADATA.typ())) : result;
		result = _isWantedPositionSet(FieldSetDepth.SHALLOW) ? (prime * result + FieldHasher.calc(getWantedPosition(), _wantedPosition_METADATA.typ())) : result;
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (Car.class != other.getClass()) return false;
		final Car o = (Car)other;
		return true
		  && (_isPositionSet(FieldSetDepth.SHALLOW) == o._isPositionSet(FieldSetDepth.SHALLOW))
		  && (_isPlayerSet(FieldSetDepth.SHALLOW) == o._isPlayerSet(FieldSetDepth.SHALLOW))
		  && (_isCurrentVelocitySet(FieldSetDepth.SHALLOW) == o._isCurrentVelocitySet(FieldSetDepth.SHALLOW))
		  && (_isWantedPositionSet(FieldSetDepth.SHALLOW) == o._isWantedPositionSet(FieldSetDepth.SHALLOW))
		  && EqualityTester.areEqual(getPosition(), o.getPosition(), _position_METADATA.typ())
		  && EqualityTester.areEqual(getPlayer(), o.getPlayer(), _player_METADATA.typ())
		  && EqualityTester.areEqual(getCurrentVelocity(), o.getCurrentVelocity(), _currentVelocity_METADATA.typ())
		  && EqualityTester.areEqual(getWantedPosition(), o.getWantedPosition(), _wantedPosition_METADATA.typ());
	}

	@Override
	public Car deepCopy() {
		final Car out = new Car();
		out.setPosition(DeepCopyer.deepCopy(getPosition(), _position_METADATA.typ()));
		out.setPlayer(DeepCopyer.deepCopy(getPlayer(), _player_METADATA.typ()));
		out.setCurrentVelocity(DeepCopyer.deepCopy(getCurrentVelocity(), _currentVelocity_METADATA.typ()));
		out.setWantedPosition(DeepCopyer.deepCopy(getWantedPosition(), _wantedPosition_METADATA.typ()));
		out._setPositionSet(_isPositionSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setPlayerSet(_isPlayerSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setCurrentVelocitySet(_isCurrentVelocitySet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
		out._setWantedPositionSet(_isWantedPositionSet(FieldSetDepth.SHALLOW), FieldSetDepth.SHALLOW);
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
				visitor.beginVisit(this, 4);
				visitor.visit(getPosition(), _position_METADATA);
				visitor.visit(getPlayer(), _player_METADATA);
				visitor.visit(getCurrentVelocity(), _currentVelocity_METADATA);
				visitor.visit(getWantedPosition(), _wantedPosition_METADATA);
				visitor.endVisit();
				break;
			}
			default /* case ALL_SET_NONTRANSIENT */ : {
				visitor.beginVisit(this, _nFieldsSet(FieldSetDepth.SHALLOW, false));
				if (_isPositionSet(FieldSetDepth.SHALLOW))
					visitor.visit(getPosition(), _position_METADATA);
				if (_isPlayerSet(FieldSetDepth.SHALLOW))
					visitor.visit(getPlayer(), _player_METADATA);
				if (_isCurrentVelocitySet(FieldSetDepth.SHALLOW))
					visitor.visit(getCurrentVelocity(), _currentVelocity_METADATA);
				if (_isWantedPositionSet(FieldSetDepth.SHALLOW))
					visitor.visit(getWantedPosition(), _wantedPosition_METADATA);
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
			case (_player_ID):
				setPlayer((String)reader.readStringField(_player_METADATA, context));
				return true;
			case (_currentVelocity_ID):
				setCurrentVelocity((se.culvertsoft.vectorrally.model.util.Vector2)reader.readMgenObjectField(_currentVelocity_METADATA, context));
				return true;
			case (_wantedPosition_ID):
				setWantedPosition((se.culvertsoft.vectorrally.model.util.Vector2)reader.readMgenObjectField(_wantedPosition_METADATA, context));
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

	public boolean _isPlayerSet(final FieldSetDepth fieldSetDepth) {
		return m_player != null;
	}

	public boolean _isCurrentVelocitySet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_currentVelocity != null;
		} else {
			return m_currentVelocity != null && Validator.validateFieldDeep(getCurrentVelocity(), _currentVelocity_METADATA.typ());
		}
	}

	public boolean _isWantedPositionSet(final FieldSetDepth fieldSetDepth) {
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return m_wantedPosition != null;
		} else {
			return m_wantedPosition != null && Validator.validateFieldDeep(getWantedPosition(), _wantedPosition_METADATA.typ());
		}
	}

	public boolean _isFieldSet(final Field field, final FieldSetDepth depth) {
		switch(field.id()) {
			case (_position_ID):
				return _isPositionSet(depth);
			case (_player_ID):
				return _isPlayerSet(depth);
			case (_currentVelocity_ID):
				return _isCurrentVelocitySet(depth);
			case (_wantedPosition_ID):
				return _isWantedPositionSet(depth);
			default:
				return false;
		}
	}

	public Car _setPlayerSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_player = m_player != null ? m_player : "";
		else
			m_player = null;
		return this;
	}

	public Car _setCurrentVelocitySet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_currentVelocity = m_currentVelocity != null ? m_currentVelocity : new se.culvertsoft.vectorrally.model.util.Vector2();
		else
			m_currentVelocity = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getCurrentVelocity(), _currentVelocity_METADATA.typ());
		return this;
	}

	public Car _setWantedPositionSet(final boolean state, final FieldSetDepth depth) {
		if (state)
			m_wantedPosition = m_wantedPosition != null ? m_wantedPosition : new se.culvertsoft.vectorrally.model.util.Vector2();
		else
			m_wantedPosition = null;
		if (depth == FieldSetDepth.DEEP)
			Marker.setFieldSetDeep(getWantedPosition(), _wantedPosition_METADATA.typ());
		return this;
	}

	public Car _setAllFieldsSet(final boolean state, final FieldSetDepth depth) { 
		_setPositionSet(state, depth);
		_setPlayerSet(state, depth);
		_setCurrentVelocitySet(state, depth);
		_setWantedPositionSet(state, depth);
		return this;
	}

	public boolean _validate(final FieldSetDepth fieldSetDepth) { 
		if (fieldSetDepth == FieldSetDepth.SHALLOW) {
			return true;
		} else {
			return true
				&& (!_isPositionSet(FieldSetDepth.SHALLOW) || _isPositionSet(FieldSetDepth.DEEP))
				&& (!_isCurrentVelocitySet(FieldSetDepth.SHALLOW) || _isCurrentVelocitySet(FieldSetDepth.DEEP))
				&& (!_isWantedPositionSet(FieldSetDepth.SHALLOW) || _isWantedPositionSet(FieldSetDepth.DEEP));
		}
	}

	@Override
	public int _nFieldsSet(final FieldSetDepth depth, final boolean includeTransient) {
		int out = 0;
		out += _isPositionSet(depth) ? 1 : 0;
		out += _isPlayerSet(depth) ? 1 : 0;
		out += _isCurrentVelocitySet(depth) ? 1 : 0;
		out += _isWantedPositionSet(depth) ? 1 : 0;
		return out;
	}

	@Override
	public Field _fieldById(final short fieldId) {
		switch(fieldId) {
			case (_position_ID):
				return _position_METADATA;
			case (_player_ID):
				return _player_METADATA;
			case (_currentVelocity_ID):
				return _currentVelocity_METADATA;
			case (_wantedPosition_ID):
				return _wantedPosition_METADATA;
			default:
				return null;
		}
	}

	@Override
	public Field _fieldByName(final String fieldName) {
		switch(fieldName) {
			case ("position"):
				return _position_METADATA;
			case ("player"):
				return _player_METADATA;
			case ("currentVelocity"):
				return _currentVelocity_METADATA;
			case ("wantedPosition"):
				return _wantedPosition_METADATA;
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
		  

	public static final long _TYPE_ID = 4485433304740590679L;

	public static final long[] _TYPE_IDS = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID, se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID };

	public static final short _TYPE_ID_16BIT = -28739;

	public static final short[] _TYPE_IDS_16BIT = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT, se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT };

	public static final String _TYPE_ID_16BIT_BASE64 = "j70";

	public static final String[] _TYPE_IDS_16BIT_BASE64 = { se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT_BASE64, se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT_BASE64 };

	public static final String _TYPE_IDS_16BIT_BASE64_STRING = se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT_BASE64 + se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT_BASE64;

	public static final String _TYPE_NAME = "se.culvertsoft.vectorrally.model.entity.Car";

	public static final String[] _TYPE_NAMES = { se.culvertsoft.vectorrally.model.MapObject._TYPE_NAME, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_NAME, se.culvertsoft.vectorrally.model.entity.Car._TYPE_NAME };

	public static final Field _position_METADATA = new Field("se.culvertsoft.vectorrally.model.entity.Car", "position", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-26337);
	public static final Field _player_METADATA = new Field("se.culvertsoft.vectorrally.model.entity.Car", "player", se.culvertsoft.mgen.api.model.StringType.INSTANCE, null, (short)6798);
	public static final Field _currentVelocity_METADATA = new Field("se.culvertsoft.vectorrally.model.entity.Car", "currentVelocity", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-7611);
	public static final Field _wantedPosition_METADATA = new Field("se.culvertsoft.vectorrally.model.entity.Car", "wantedPosition", new se.culvertsoft.mgen.api.model.RuntimeClassType("se.culvertsoft.vectorrally.model.util.Vector2", 2411142272178246518L), null, (short)-5001);

	public static final short _position_ID = (short)-26337;
	public static final short _player_ID = (short)6798;
	public static final short _currentVelocity_ID = (short)-7611;
	public static final short _wantedPosition_ID = (short)-5001;

	public static final Field[] _FIELDS = { _position_METADATA, _player_METADATA, _currentVelocity_METADATA, _wantedPosition_METADATA };

}
