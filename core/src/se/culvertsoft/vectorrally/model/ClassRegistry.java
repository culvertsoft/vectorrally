/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model;

import se.culvertsoft.mgen.javapack.classes.ClassRegistryEntry;
import se.culvertsoft.mgen.javapack.classes.Ctor;
import se.culvertsoft.mgen.javapack.classes.MGenBase;

public class ClassRegistry extends se.culvertsoft.mgen.javapack.classes.ClassRegistryBase {

	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_Game = new ClassRegistryEntry(3993833445368397183L, se.culvertsoft.vectorrally.model.Game._TYPE_IDS, "se.culvertsoft.vectorrally.model.Game", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.Game(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_Map = new ClassRegistryEntry(4343410752178357644L, se.culvertsoft.vectorrally.model.Map._TYPE_IDS, "se.culvertsoft.vectorrally.model.Map", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.Map(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_MapObject = new ClassRegistryEntry(2054525997235029554L, se.culvertsoft.vectorrally.model.MapObject._TYPE_IDS, "se.culvertsoft.vectorrally.model.MapObject", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.MapObject(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_util_Vector2 = new ClassRegistryEntry(2411142272178246518L, se.culvertsoft.vectorrally.model.util.Vector2._TYPE_IDS, "se.culvertsoft.vectorrally.model.util.Vector2", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.util.Vector2(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_line_Line = new ClassRegistryEntry(5426693121306130889L, se.culvertsoft.vectorrally.model.line.Line._TYPE_IDS, "se.culvertsoft.vectorrally.model.line.Line", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.line.Line(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_line_Wall = new ClassRegistryEntry(4052439023122991418L, se.culvertsoft.vectorrally.model.line.Wall._TYPE_IDS, "se.culvertsoft.vectorrally.model.line.Wall", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.line.Wall(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_line_Start = new ClassRegistryEntry(7788882401246578156L, se.culvertsoft.vectorrally.model.line.Start._TYPE_IDS, "se.culvertsoft.vectorrally.model.line.Start", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.line.Start(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_line_Goal = new ClassRegistryEntry(3080967789489705218L, se.culvertsoft.vectorrally.model.line.Goal._TYPE_IDS, "se.culvertsoft.vectorrally.model.line.Goal", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.line.Goal(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_entity_Entity = new ClassRegistryEntry(6829095988463092030L, se.culvertsoft.vectorrally.model.entity.Entity._TYPE_IDS, "se.culvertsoft.vectorrally.model.entity.Entity", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.entity.Entity(); } });
	public static ClassRegistryEntry se_culvertsoft_vectorrally_model_entity_Car = new ClassRegistryEntry(4485433304740590679L, se.culvertsoft.vectorrally.model.entity.Car._TYPE_IDS, "se.culvertsoft.vectorrally.model.entity.Car", new Ctor() { public MGenBase create() { return new se.culvertsoft.vectorrally.model.entity.Car(); } });

	public ClassRegistry() {
		add(se_culvertsoft_vectorrally_model_Game);
		add(se_culvertsoft_vectorrally_model_Map);
		add(se_culvertsoft_vectorrally_model_MapObject);
		add(se_culvertsoft_vectorrally_model_util_Vector2);
		add(se_culvertsoft_vectorrally_model_line_Line);
		add(se_culvertsoft_vectorrally_model_line_Wall);
		add(se_culvertsoft_vectorrally_model_line_Start);
		add(se_culvertsoft_vectorrally_model_line_Goal);
		add(se_culvertsoft_vectorrally_model_entity_Entity);
		add(se_culvertsoft_vectorrally_model_entity_Car);
	}

	@Override
	public ClassRegistryEntry getByTypeIds16Bit(final short[] ids) {
		int i = 0;
		switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
			case se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT:
				return se_culvertsoft_vectorrally_model_Game;
			case se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT:
				return se_culvertsoft_vectorrally_model_Map;
			case se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT:
				switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
					case se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT:
						switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
							case se.culvertsoft.vectorrally.model.line.Wall._TYPE_ID_16BIT:
								return se_culvertsoft_vectorrally_model_line_Wall;
							case se.culvertsoft.vectorrally.model.line.Start._TYPE_ID_16BIT:
								return se_culvertsoft_vectorrally_model_line_Start;
							case se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT:
								return se_culvertsoft_vectorrally_model_line_Goal;
							default:
								return se_culvertsoft_vectorrally_model_line_Line;
						}
					case se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT:
						switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
							case se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT:
								return se_culvertsoft_vectorrally_model_entity_Car;
							default:
								return se_culvertsoft_vectorrally_model_entity_Entity;
						}
					default:
						return se_culvertsoft_vectorrally_model_MapObject;
				}
			case se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT:
				return se_culvertsoft_vectorrally_model_util_Vector2;
			default:
				return null;
		}
	}

	@Override
	public ClassRegistryEntry getByTypeIds16BitBase64(final String[] ids) {
		int i = 0;
		switch((i < ids.length ? ids[i++] : "0xFFFFFFFF")) {
			case se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT_BASE64:
				return se_culvertsoft_vectorrally_model_Game;
			case se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT_BASE64:
				return se_culvertsoft_vectorrally_model_Map;
			case se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT_BASE64:
				switch((i < ids.length ? ids[i++] : "0xFFFFFFFF")) {
					case se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT_BASE64:
						switch((i < ids.length ? ids[i++] : "0xFFFFFFFF")) {
							case se.culvertsoft.vectorrally.model.line.Wall._TYPE_ID_16BIT_BASE64:
								return se_culvertsoft_vectorrally_model_line_Wall;
							case se.culvertsoft.vectorrally.model.line.Start._TYPE_ID_16BIT_BASE64:
								return se_culvertsoft_vectorrally_model_line_Start;
							case se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT_BASE64:
								return se_culvertsoft_vectorrally_model_line_Goal;
							default:
								return se_culvertsoft_vectorrally_model_line_Line;
						}
					case se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT_BASE64:
						switch((i < ids.length ? ids[i++] : "0xFFFFFFFF")) {
							case se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT_BASE64:
								return se_culvertsoft_vectorrally_model_entity_Car;
							default:
								return se_culvertsoft_vectorrally_model_entity_Entity;
						}
					default:
						return se_culvertsoft_vectorrally_model_MapObject;
				}
			case se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT_BASE64:
				return se_culvertsoft_vectorrally_model_util_Vector2;
			default:
				return null;
		}
	}

}
