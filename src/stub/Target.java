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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


public class Target {

    public final static String DefaultName = "DebugGraphics2D.java";


    public final String targetName, baseName, packageName, className;

    public final File targetFile;

    public final Source source;


    public Target(Arguments args, Source source){
        super();
        if (null != args){
            if (null != args.target)
                this.targetName = args.target;
            else
                this.targetName = Target.DefaultName;

            if (null != source){
                this.source = source;
                /*
                 */
                this.targetFile = new File(this.targetName);

                this.baseName = Target.Basename(this.targetFile.getName());

                this.packageName = Target.PackageName(this.targetName);

                if (null != this.packageName)
                    this.className = this.packageName+'.'+this.baseName;
                else
                    this.className = this.baseName;
            }
            else
                throw new IllegalArgumentException();
        }
        else
            throw new IllegalArgumentException();
    }


    public void write() throws IOException {

        this.write(this.targetFile);
    }
    public void write(File outfile) throws IOException {

        this.write(new FileOutputStream(outfile));
    }
    public void write(OutputStream out) throws IOException {

        this.write(new PrintStream(out));
    }
    public void write(PrintStream out) throws IOException {

        if (null != this.packageName)
            out.printf("package %s;%n",this.packageName);

        if (this.source.hasImports()){
            out.println();
            out.println();
            for (Source.Type type: this.source.imports()){

                out.printf("import %s;%n",type.fullName);
            }
        }
        out.println();
        out.println();
        out.printf( "public class %s%n",this.baseName);
        out.printf( "    extends %s%n",this.source.sourceName);
        out.println("{");
        out.println();
        out.println();
        out.printf( "    private %s instance;%n",this.source.sourceName);
        out.println();
        out.println();
        out.printf( "    public %s(%s instance){%n",this.baseName,this.source.sourceName);
        out.println("        super();");
        out.println("        if (null != instance)");
        out.println("            this.instance = instance;");
        out.println("        else");
        out.println("            throw new IllegalArgumentException();");
        out.println("    }");

        int cc;
        if (this.source.hasMethods()){
            out.println();
            out.println();
            for (Source.Method method: this.source.methods()){
                out.printf( "    public %s %s(",method.rtype.baseName,method.name);
                {
                    cc = 0;
                    for (Source.Type ptype: method.parameters()){
                        if (0 != cc)
                            out.print(", ");

                        out.printf("%s %s",ptype.baseName,method.parameterName(cc));
                        cc += 1;
                    }
                }
                out.println("){");
                if (method.isNotVoid){
                    out.printf( "        return this.instance.%s(",method.name);
                    {
                        cc = 0;
                        for (Source.Type ptype: method.parameters()){
                            if (0 != cc)
                                out.print(", ");

                            out.printf("%s %s",ptype.baseName,method.parameterName(cc));
                            cc += 1;
                        }
                    }
                    out.println(");");
                }
                else {
                    out.printf( "        this.instance.%s(",method.name);
                    {
                        cc = 0;
                        for (Source.Type ptype: method.parameters()){
                            if (0 != cc)
                                out.print(", ");

                            out.printf("%s",method.parameterName(cc));
                            cc += 1;
                        }
                    }
                    out.println(");");
                }
                out.println("    }");
            }
        }
        else {
            out.println();
        }
        out.println("}");
    }

    public final static String Basename(String name){

        return name.substring(0,name.indexOf('.'));
    }
    public final static String PackageName(String path){

        int idx = path.indexOf("/src/");

        if (-1 < idx){

            String packagePath = path.substring(idx+"/src/".length());

            idx = packagePath.lastIndexOf('/');

            if (-1 < idx){
                packagePath = packagePath.substring(0,idx).replace('/','.');

                if (0 < packagePath.length()){
                    return packagePath;
                }
            }
        }
        return null;
    }
}
