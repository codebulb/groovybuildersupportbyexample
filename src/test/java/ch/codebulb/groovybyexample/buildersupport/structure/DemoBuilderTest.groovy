package ch.codebulb.groovybyexample.buildersupport.structure

import org.junit.Test
import static org.junit.Assert.*
import ch.codebulb.groovybyexample.buildersupport.model.*

class DemoBuilderTest {
    @Test
    public void testWithPlainGroovy() {
        createDemoHousehold()
    }
    
    protected Household createDemoHousehold() {
        Household household = new Household("main street 42")
        household << new Car("VW", 15000)
        Room livingRoom = new Room("living room")
        livingRoom.furniture << new Furniture("TV", 2000)
        livingRoom.furniture << new Furniture("sofa", 1000)
        household.rooms << livingRoom
        return household
    }
    
    @Test
    public void testWithBuilder() {
        new DemoBuilder().build {
            household(adress: "main street 42") {
                car("VW", price: 15000)
                room {
                    name("living room")
                    furniture(name: "TV", price: 2000)
                    furniture(name: "sofa", price: 1000)
                }
            }
        }
    }
    
    @Test
    public void testWithBuilderIllegalMethod() {
        try {
            buildWithIllegalMethod(new DemoBuilder())
            fail("Excpected method not thrown.")
        }
        catch (MissingMethodException ex) {}
        
        buildWithIllegalMethod(new DemoBuilderPlus())
    }
    
    private void buildWithIllegalMethod(DemoBuilder builder) {
        builder.build {
            household(adress: "main street 42") {
                car("VW", 15000)
            }
        }
    }
}
