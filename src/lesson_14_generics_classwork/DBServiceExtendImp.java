package lesson_14_generics_classwork;
/*Реализация интерфейса работающая только с типами, которые
* являются наследниками Cl2
* Cl2 является наследником себя*/
class DBServiceExtendImp<T,U extends Cl2> implements DBServiceExtend<Cl2,Cl4> {
    @Override
    public void save(Cl2 entry) {

    }

    @Override
    public void delete(Cl2 entry) {

    }

    @Override
    public Cl2 getUser(Cl4 id) {
        return null;
    }

    @Override
    public Cl2 update(Cl2 entry) {
        return null;
    }
}