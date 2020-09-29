public class RelationalCalculator extends AbstractCalculator {

    public RelationalCalculator(){
        super((x,y)->{
            Number result = new Number();
            double a;
            double b;
            if(x.getB()!=y.getB()){
                a = x.getA()*y.getB()+y.getA()*x.getB();
                b = x.getB()*y.getB();
            }else{
                a = x.getA() + y.getA();
                b = x.getB();
            }
            result.setA(a);
            result.setB(b);
            return result;
        },(x, y) -> {
            Number result = new Number();
            double a;
            double b;
            if(x.getB()!=y.getB()){
                a = x.getA()*y.getB()-y.getA()*x.getB();
                b = x.getB()*y.getB();
            }else{
                a = x.getA() - y.getA();
                b = x.getB();
            }
            result.setA(a);
            result.setB(b);
            return result;
        },(x, y) -> {
            Number result = new Number();
            result.setA(x.getA()*y.getA());
            result.setB(x.getB()*y.getB());
            return result;
        },(x, y) -> {
            Number result = new Number();
            result.setA(x.getA()*y.getB());
            result.setB(x.getB()*y.getA());
            return result;
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
