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

public class Handler {

	protected void handleDiscard(MGenBase o) {}

	protected void handleNull(MGenBase o) { handleDiscard(o); }

	protected void handleUnknown(MGenBase o) { handleDiscard(o); }

	protected void handle(se.culvertsoft.vectorrally.model.Game o) {
		handleDiscard(o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.Map o) {
		handleDiscard(o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.MapObject o) {
		handleDiscard(o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.util.Vector2 o) {
		handleDiscard(o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.line.Line o) {
		handle((se.culvertsoft.vectorrally.model.MapObject)o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.line.Wall o) {
		handle((se.culvertsoft.vectorrally.model.line.Line)o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.line.Start o) {
		handle((se.culvertsoft.vectorrally.model.line.Line)o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.line.Goal o) {
		handle((se.culvertsoft.vectorrally.model.line.Line)o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.entity.Entity o) {
		handle((se.culvertsoft.vectorrally.model.MapObject)o);
	}

	protected void handle(se.culvertsoft.vectorrally.model.entity.Car o) {
		handle((se.culvertsoft.vectorrally.model.entity.Entity)o);
	}

}
