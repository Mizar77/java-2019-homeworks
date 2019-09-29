package creator;

import creator.Creator;
import figure.BasicFigure;
import figure.Figure;

public class FigureCreator<T extends Figure> extends BasicCreator<T> {
    public FigureCreator(Class<? extends T> type, Class<?>... ctorArgTypes) {
        super(type, ctorArgTypes);
    }
}
