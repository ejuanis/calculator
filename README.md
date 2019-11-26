# Calculator
This calculator project is built using Maven.

### Summary
#### Solution
Step 1: Breaking down the equation into linked nodes. Using a loop to iterates the node to compare the mathematical operation between and evaluate the equation if it has a higher priority compared to the adjacent node operation.

Step 2: For the equation with bracket, by using String::indexOf find the inner bracket for nested bracket then evaluate the equation inside the bracket. Then, replace the bracket equation with the calculated answer using Step 1. After that Use recursive method to solve the remining bracket equation.

Time taken to complete this project ~2 days (Coding efforts 10hrs)

### How to use this API?
1. Clone this repository
2. Run ``mvn clean install`` to install into local maven repo.
3. Import into another project. Add the dependency into ``pom.xml``

       <dependencies>
            <dependency>
                <groupId>com.eranis</groupId>
                <artifactId>calculator</artifactId>
                <version>1.0.0</version>
            </dependency>
        </dependencies>

4. Then import ``import com.eranis.calculator.Calculator;``

5. Sample usage:

```java
package com.eranis.calculatoruser;

import com.eranis.calculator.Calculator;

public class CalculatorUser {
    public static void main(String[] args) {
        System.out.println(Calculator.calculate("1 + 1 * 3"));
    }
}
```
