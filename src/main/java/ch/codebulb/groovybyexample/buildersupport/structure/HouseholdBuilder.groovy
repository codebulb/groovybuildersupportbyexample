package ch.codebulb.groovybyexample.buildersupport.structure

import ch.codebulb.groovybyexample.buildersupport.model.*

class HouseholdBuilder extends BuilderSupport {
    private static final String MODEL_PACKAGE = "ch.codebulb.groovybyexample.buildersupport.model"
    
    private static final Map SUPPORTED_MODELS = [
        // explicit relations method name -> node class
        build: ArrayList,
    ].withDefault {
        // implicit relations method name -> node class
        Class.forName("${MODEL_PACKAGE}.${it.capitalize()}")
    }
    
    @Override
    public void setParent(Object parent, Object child) {
        if (parent == child) return
        parent << child
    }
    
    @Override
    public Object createNode(Object name) {
       return createNode(name, null, null);
    }

    @Override
    public Object createNode(Object name, Object value) {
       return createNode(name, null, value);
    }

    @Override
    public Object createNode(Object name, Map attrs) {
       return createNode(name, attrs, null);
    }

    @Override
    public Object createNode(Object name, Map attrs, Object value) {
        try {
            def instance
            if (!value) {
                // use default constructor
                instance = SUPPORTED_MODELS[name].newInstance()
            }
            else {
                // use constructor with 1 argument
                instance = SUPPORTED_MODELS[name].newInstance(value)
            }
            // set properties
            attrs.each {k, v -> instance."$k" = v}
            return instance
        }
        catch (ClassNotFoundException ex) {
            /*
             * No class is found.
             * We do not actually create a new node, but alter a property
             * of the current node
             */
            if (value && !attrs) {
                // This is only valid if value is present, but attrs isn't
                current."$name" = value
                return current
            }
            else {
                throw ex
            }
        }
    }
}
