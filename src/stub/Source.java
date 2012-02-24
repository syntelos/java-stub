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

import java.lang.reflect.Modifier;

public class Source {

    public final static String DefaultName = "java.awt.Graphics2D";

    private final static Class ObjectClass = java.lang.Object.class;


    public final String sourceName, packageName, baseName;

    public final Class sourceClass;
    /*
     * All public not from "java.lang.Object"
     */
    private Method[] methods;
    /*
     * All types mentioned in methods not in "java.lang"
     */
    private Source.Type[] imports;


    public Source(Arguments args)
        throws ClassNotFoundException
    {
        super();
        if (null != args.source)
            this.sourceName = args.source;
        else
            this.sourceName = Source.DefaultName;

        this.sourceClass = Class.forName(this.sourceName);

        this.packageName = Source.PackageName(this.sourceName);
        this.baseName = Source.Basename(this.sourceName);
    }


    public void read() throws SecurityException {
        Source.Method[] methods = null;
        Source.Type.Map typeMap = new Source.Type.Map();
        /*
         * Collect methods and types
         */
        for (java.lang.reflect.Method method : this.sourceClass.getMethods()){

            if (Source.ObjectClass != method.getDeclaringClass() && 
                Modifier.isPublic(method.getModifiers()))
            {
                Source.Method sourceMethod = new Source.Method(typeMap,method);

                methods = Source.Method.Add(methods,sourceMethod);
            }
        }
        this.methods = methods;
        /*
         * Collect types not "java.lang"
         */
        Source.Type[] typeList = null;
        for (Source.Type typeClass: typeMap.values()){
            if (!typeClass.isJavaLang)
                typeList = Source.Type.Add(typeList,typeClass);
        }
        this.imports = typeList;
    }
    public boolean hasMethods(){
        return (null != this.methods);
    }
    public Iterable<Method> methods(){
        return new Source.Methods(this.methods);
    }
    public boolean hasImports(){
        return (null != this.imports);
    }
    public Iterable<Type> imports(){
        return new Source.Types(this.imports);
    }


    public final static String Basename(String name){
        final int idx = name.lastIndexOf('.');
        if (-1 < idx)
            return name.substring(idx+1);
        else
            return name;
    }
    public final static String PackageName(String name){
        final int idx = name.lastIndexOf('.');
        if (-1 < idx)
            return name.substring(0,idx);
        else
            return name;
    }
    public static class Methods
        extends Object
        implements Iterable<Method>,
                   java.util.Iterator<Method>
    {
        private final Method[] list;
        private final int length;
        private int index;

        public Methods(Method[] list){
            super();
            if (null == list){
                this.list = null;
                this.length = 0;
            }
            else {
                this.list = list;
                this.length = list.length;
            }
        }

        public java.util.Iterator<Method> iterator(){
            return this;
        }
        public boolean hasNext(){
            return (this.index < this.length);
        }
        public Method next(){
            if (this.index < this.length)
                return this.list[this.index++];
            else
                throw new java.util.NoSuchElementException(String.valueOf(this.index));
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    public static class Types
        extends Object
        implements Iterable<Type>,
                   java.util.Iterator<Type>
    {
        private final Type[] list;
        private final int length;
        private int index;

        public Types(Type[] list){
            super();
            if (null == list){
                this.list = null;
                this.length = 0;
            }
            else {
                this.list = list;
                this.length = list.length;
            }
        }

        public java.util.Iterator<Type> iterator(){
            return this;
        }
        public boolean hasNext(){
            return (this.index < this.length);
        }
        public Type next(){
            if (this.index < this.length)
                return this.list[this.index++];
            else
                throw new java.util.NoSuchElementException(String.valueOf(this.index));
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    public static class Type {


        public final Class typeClass;

        public final String fullName, baseName, packageName, shortName;

        public final boolean isJavaLang, isPrimitive, isNotVoid;


        public Type(Class typeClass){
            super();
            if (typeClass.isPrimitive()){

                this.typeClass = typeClass;
                this.fullName = typeClass.getName();

                if (java.lang.Boolean.TYPE == typeClass){
                    this.baseName = "boolean";
                    this.shortName = "bool";
                    this.isNotVoid = true;
                }
                else if (java.lang.Character.TYPE == typeClass){
                    this.baseName = "char";
                    this.shortName = "ch";
                    this.isNotVoid = true;
                }
                else if (java.lang.Byte.TYPE == typeClass){
                    this.baseName = "byte";
                    this.shortName = "bb";
                    this.isNotVoid = true;
                }
                else if (java.lang.Short.TYPE == typeClass){
                    this.baseName = "short";
                    this.shortName = "sh";
                    this.isNotVoid = true;
                }
                else if (java.lang.Integer.TYPE == typeClass){
                    this.baseName = "int";
                    this.shortName = "a";
                    this.isNotVoid = true;
                }
                else if (java.lang.Long.TYPE == typeClass){
                    this.baseName = "long";
                    this.shortName = "lon";
                    this.isNotVoid = true;
                }
                else if (java.lang.Float.TYPE == typeClass){
                    this.baseName = "float";
                    this.shortName = "flo";
                    this.isNotVoid = true;
                }
                else if (java.lang.Double.TYPE == typeClass){
                    this.baseName = "double";
                    this.shortName = "dob";
                    this.isNotVoid = true;
                }
                else if (java.lang.Void.TYPE == typeClass){
                    this.baseName = "void";
                    this.shortName = "";
                    this.isNotVoid = false;
                }
                else
                    throw new IllegalStateException(typeClass.getName());

                this.packageName = "java.lang";
                this.isJavaLang = true;
                this.isPrimitive = true;
            }
            else {
                this.typeClass = typeClass;
                this.fullName = typeClass.getName();
                this.baseName = Source.Basename(this.fullName);
                this.packageName = Source.PackageName(this.fullName);
                this.isJavaLang = ("java.lang".equals(this.packageName));
                this.isPrimitive = false;
                this.isNotVoid = true;
                this.shortName = Decamel(this.baseName);
            }
        }


        /**
         */
        public final static Type[] Add(Type[] list, Type item){
            if (null == item)
                return list;
            else if (null == list)
                return new Type[]{item};
            else {
                final int count = list.length;
                Type[] copier = new Type[count+1];
                System.arraycopy(list,0,copier,0,count);
                copier[count] = item;
                return copier;
            }
        }
        public final static String Decamel(String name){
            return (name.substring(0,1).toLowerCase()+name.substring(1));
        }
        /**
         */
        public static class Map 
            extends java.util.HashMap<Class,Type>
        {

            public Map(){
                super();
            }

            public Source.Type get(Class typeClass){
                Source.Type value = super.get(typeClass);
                if (null == value){
                    value = new Source.Type(typeClass);
                    super.put(typeClass,value);
                }
                return value;
            }
            public Source.Type[] get(Class[] typeClasses){
                Source.Type[] list = null;
                for (Class typeClass: typeClasses){
                    Source.Type type = this.get(typeClass);
                    list = Source.Type.Add(list,type);
                }
                return list;
            }
        }
    }
    public static class Method {

        public final java.lang.reflect.Method method;

        public final Type rtype;

        public final String name;

        public final boolean isNotVoid;

        private final Type[] ptypes;

        private final Type[] xtypes;

        private String[] pNames;


        public Method(Source.Type.Map typeMap, java.lang.reflect.Method method){
            super();
            this.method = method;

            this.name = method.getName();

            this.rtype = typeMap.get(method.getReturnType());

            this.isNotVoid = rtype.isNotVoid;

            this.ptypes = typeMap.get(method.getParameterTypes());

            this.xtypes = typeMap.get(method.getExceptionTypes());
            {
                java.lang.reflect.TypeVariable<java.lang.reflect.Method>[] parameters = method.getTypeParameters();
                int count = parameters.length;
                if (0 == count){
                    if (this.hasParameters()){
                        count = this.ptypes.length;
                        String[] pNames = new String[count];
                        for (int cc = 0; cc < count; cc++){
                            pNames[cc] = this.ptypes[cc].shortName;
                        }
                        this.pNames = pNames;
                    }
                    else
                        this.pNames = null;
                }
                else {
                    String[] pNames = new String[count];
                    for (int cc = 0; cc < count; cc++){
                        pNames[cc] = parameters[cc].getName();
                    }
                    this.pNames = pNames;
                }
            }
        }


        public boolean hasParameters(){
            return (null != this.ptypes);
        }
        public Iterable<Type> parameters(){
            return new Source.Types(this.ptypes);
        }
        public boolean hasExceptions(){
            return (null != this.xtypes);
        }
        public Iterable<Type> exceptions(){
            return new Source.Types(this.xtypes);
        }
        public String parameterName(int index){

            return this.pNames[index];
        }


        /**
         */
        public final static Method[] Add(Method[] list, Method item){
            if (null == item)
                return list;
            else if (null == list)
                return new Method[]{item};
            else {
                final int count = list.length;
                Method[] copier = new Method[count+1];
                System.arraycopy(list,0,copier,0,count);
                copier[count] = item;
                return copier;
            }
        }
    }
}
