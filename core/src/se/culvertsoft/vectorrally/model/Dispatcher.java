/********************************************************************************************************************
 ********************************************************************************************************************
 **********************************************************************************************************	
           *****                                                                                      *****
           *****                               GENERATED WITH MGEN                                    *****
           *****                                                                                      *****		
 ********************************************************************************************************************
 ********************************************************************************************************************/
package se.culvertsoft.vectorrally.model;

import se.culvertsoft.mgen.javapack.classes.MGenBase;

public class Dispatcher {

	public static void dispatch(MGenBase o, Handler handler) {

		if (o==null) {
			handler.handleNull(o);
			return;
		}

		final short[] ids = o._typeIds16Bit();
		int i = 0;
		switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
			case se.culvertsoft.vectorrally.model.Game._TYPE_ID_16BIT:
				handler.handle((se.culvertsoft.vectorrally.model.Game)o);
				break;
			case se.culvertsoft.vectorrally.model.Map._TYPE_ID_16BIT:
				handler.handle((se.culvertsoft.vectorrally.model.Map)o);
				break;
			case se.culvertsoft.vectorrally.model.MapObject._TYPE_ID_16BIT:
				switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
					case se.culvertsoft.vectorrally.model.line.Line._TYPE_ID_16BIT:
						switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
							case se.culvertsoft.vectorrally.model.line.Wall._TYPE_ID_16BIT:
								handler.handle((se.culvertsoft.vectorrally.model.line.Wall)o);
								break;
							case se.culvertsoft.vectorrally.model.line.Start._TYPE_ID_16BIT:
								handler.handle((se.culvertsoft.vectorrally.model.line.Start)o);
								break;
							case se.culvertsoft.vectorrally.model.line.Goal._TYPE_ID_16BIT:
								handler.handle((se.culvertsoft.vectorrally.model.line.Goal)o);
								break;
							default:
								handler.handle((se.culvertsoft.vectorrally.model.line.Line)o);
								break;
						}
						break;
					case se.culvertsoft.vectorrally.model.entity.Entity._TYPE_ID_16BIT:
						switch((i < ids.length ? (int)ids[i++] : 0xFFFFFFFF)) {
							case se.culvertsoft.vectorrally.model.entity.Car._TYPE_ID_16BIT:
								handler.handle((se.culvertsoft.vectorrally.model.entity.Car)o);
								break;
							default:
								handler.handle((se.culvertsoft.vectorrally.model.entity.Entity)o);
								break;
						}
						break;
					default:
						handler.handle((se.culvertsoft.vectorrally.model.MapObject)o);
						break;
				}
				break;
			case se.culvertsoft.vectorrally.model.util.Vector2._TYPE_ID_16BIT:
				handler.handle((se.culvertsoft.vectorrally.model.util.Vector2)o);
				break;
			default:
				handler.handleUnknown(o);
				break;
		}
	}

}
