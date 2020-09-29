public class ComplexCalculator extends AbstractCalculator {

    public ComplexCalculator(){
        super((x,y)->{
            Number solution = new Number();
            solution.setA(x.getA()+y.getA());
            solution.setB(x.getB()+y.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()-y.getA());
            solution.setB(x.getB()-y.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            double aTimesA = x.getA() * y.getA();
            double aTimesB = x.getA() * y.getB();
            double bTimesB = x.getB() * y.getB();
            double bTimesA = x.getB() * y.getA();
            solution.setA(aTimesA+(bTimesB*-1));
            solution.setB(aTimesB+bTimesA);
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            double divider = Math.pow(y.getA(),2)+Math.pow(y.getB(),2);
            solution.setA((x.getA() * y.getA() + x.getB() * y.getB()) / divider);
            solution.setB((x.getB() * y.getA() - x.getA() * y.getB()) / divider);
            return solution;
        });
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a,b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a,b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a,b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a,b);
    }
}
