/*
 * Java Class Stub Generator, "stub"
 * Copyright (C) 2012 John Pritchard
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package stub;

public class Main {

    public static void help(){
        System.err.println("Usage");
        System.err.println();
        System.err.println("    stub.Main ");
        System.err.println();
        System.err.println("Description");
        System.err.println();
        System.err.println("    Use default source Graphics2D and target DebugGraphics2D.");
        System.err.println();
        System.err.println("Usage");
        System.err.println();
        System.err.println("    stub.Main --help");
        System.err.println();
        System.err.println("Description");
        System.err.println();
        System.err.println("    Print this message.");
        System.err.println();
        System.err.println("Usage");
        System.err.println();
        System.err.println("    stub.Main --print");
        System.err.println();
        System.err.println("Description");
        System.err.println();
        System.err.println("    Instrument stub class with 'System.err.print'.");
        System.err.println();
        System.err.println("Usage");
        System.err.println();
        System.err.println("    stub.Main --source class.name --target file.java");
        System.err.println();
        System.err.println("Description");
        System.err.println();
        System.err.println("    Use source and target as specified.");
        System.err.println();
        System.err.println("    When the target file path includes '/src/', a");
        System.err.println("    package name will be identified and employed.");
        System.err.println("    Requires '/' path separators.");
        System.err.println();
        System.err.println("Example");
        System.err.println();
        System.err.println("    java -jar stub.jar ");
        System.err.println("         --source java.awt.Graphics2D");
        System.err.println("         --target ./src/local/DebugGraphics2D.java");
        System.err.println("         --print");
        System.err.println();
    }

    public static void main(String[] argv){
        try {
            Arguments args = new Arguments(argv);
            if (args.requireHelp){
                Main.help();
                System.exit(1);
            }
            else {
                Source source = new Source(args);
                Target target = new Target(args,source);
                source.read();
                target.write();
                System.exit(0);
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
            System.exit(1);
        }
    }
}
