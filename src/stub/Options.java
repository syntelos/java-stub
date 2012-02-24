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

public enum Options {

    source (true,false), target (true,false), help (false,true), print (false,false);


    public final boolean requiresArg, isHelp;

    private Options(boolean arg, boolean help){
        this.requiresArg = arg;
        this.isHelp = help;
    }

    public final static Options For(String arg){
        if (null == arg)
            return Options.help;
        else {
            while (0 < arg.length() && '-' == arg.charAt(0)){
                arg = arg.substring(1);
            }
            try {
                return Options.valueOf(arg.toLowerCase());
            }
            catch (RuntimeException rex){

                return Options.help;
            }
        }
    }
}