class WorkFlowStateProcess<T, TState> implements IWorkFlowStateProcess<T>
{
    T record
    TState currentState
    TState nextState
    @Override
    boolean proceedNextStateProcessWhen()
    {
        return false
    }
    @Override
    T proceedNextStateProcess()
    {
        return null
    }
}
