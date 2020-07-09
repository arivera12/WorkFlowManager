interface IWorkFlowStateProcess<T>
{
    boolean proceedNextStateProcessWhen()
    T proceedNextStateProcess()
}