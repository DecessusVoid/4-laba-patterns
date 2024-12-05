interface Handler {
    void handleRequest(Request request);
    void setNextHandler(Handler nextHandler);
}


class ConcreteHandlerA implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE_A) {
            System.out.println("ConcreteHandlerA handled  requests.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}


class ConcreteHandlerB implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE_B) {
            System.out.println("ConcreteHandlerB handled requests.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Запрос
class Request {
    private RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}
enum RequestType {
    TYPE_A, TYPE_B
}


public class Resp_chain {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        handlerA.setNextHandler(handlerB);

        Request requestA = new Request(RequestType.TYPE_A);
        Request requestB = new Request(RequestType.TYPE_B);

        handlerA.handleRequest(requestA); 
        handlerA.handleRequest(requestB); 
    }
}