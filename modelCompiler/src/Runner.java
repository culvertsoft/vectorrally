import se.culvertsoft.mgen.compiler.MGenCompiler;


public class Runner {

	public static void main(String[] args) {
		MGenCompiler.main(new String[]{"-project=\"resources/project.xml\"","-output_path=../core"});
	}

}
