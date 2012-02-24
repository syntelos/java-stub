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

public class Arguments {

    public final String source, target;

    public final boolean doPrint, requireHelp;

    public Arguments(String[] argv){
        super();
        String source = null, target = null;
        boolean requireHelp = false, doPrint = false;
        for (int cc = 0, count = argv.length; cc < count; cc++){
            String arg = argv[cc];
            Options option = Options.For(arg);
            if (option.requiresArg){
                cc += 1;
                if (cc < count){
                    arg = argv[cc];
                    switch(option){
                    case source:
                        source = arg;
                        break;
                    case target:
                        target = arg;
                        break;
                    default:
                        throw new IllegalStateException(option.name());
                    }
                }
                else
                    requireHelp = true;
            }
            else {
                switch(option){
                case print:
                    doPrint = true;
                    break;
                case help:
                    requireHelp = true;
                default:
                    throw new IllegalStateException(option.name());
                }
            }
        }
        this.source = source;
        this.target = target;
        this.requireHelp = requireHelp; 
        this.doPrint = doPrint;
    }

}
