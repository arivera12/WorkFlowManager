interface IWorkFlowStateProcess<T, TState>
{
    boolean proceedNextStateProcessWhen()
    T proceedNextStateProcess()
}