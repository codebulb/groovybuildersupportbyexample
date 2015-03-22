package ch.codebulb.groovybyexample.buildersupport.structure

import org.junit.Test
import static org.junit.Assert.*

import ch.codebulb.groovybyexample.buildersupport.model.*

class HouseholdBuilderTest extends DemoBuilderTest {
    @Test
    public void testWithBuilder() {
        assert [createDemoHousehold()] == new HouseholdBuilder().build {
            household(address: "main street 42") {
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
    public void testWithCollection() {
        assert 2 == new HouseholdBuilder().build {
            household(address: "main street 42")
            household(address: "main street 44")
        }.size()
    }
    
    @Test
    public void testWithFactoryMethod() {
        assert new HouseholdBuilderPlus().build { household(address: "main street 42") } ==
            HouseholdBuilderPlus.build { household(address: "main street 42") }
    }
    
    @Test
    public void testWithConvenienceMethod() {
        assert HouseholdBuilderPlus.build {
            household(address: "main street 42") {
                room {
                    name("living room")
                    furniture(name: "TV", price: 2000)
                    furniture(name: "sofa", price: 1000)
                    furniture(name: "TV2", price: 2000)
                }
            }
        } == HouseholdBuilderPlus.build {
            household(address: "main street 42") {
                livingRoom {
                    furniture(name: "TV2", price: 2000)
                }
            }
        }
    }
    
    @Test
    public void testWithInlineCode() {
        HouseholdBuilderPlus.build {
            household(address: "main street 42") {
                car("VW", price: 15000)
                car("VW", price: 15000)
            }
        } == HouseholdBuilderPlus.build {
            household(address: "main street 42") {
                2. times { car("VW", price: 15000) }
            }
        }
    }
    
    @Test
    public void testWithAutoToString() {
        assert [createDemoHousehold()] == HouseholdBuilderPlus.build {
            household(address: "main street 42") {
                car(VW, price: 15000)
                room {
                    name(livingRoom)
                    furniture(name: TV, price: 2000)
                    furniture(name: sofa, price: 1000)
                }
            }
        }
    }
}
