class WorkFlowManager<T, TState> implements IWorkFlowManager<T, TState>
{
    T record;
    String statePropertyName;
    List<WorkFlowStateProcess<T, TState>> workFlowStateProcesses
    @Override
    T runWorkFlowProcess()
    {
        if(statePropertyName == null || statePropertyName.isEmpty() || statePropertyName.isAllWhitespace())
            throw new Exception("The statePropertyName is null, empty or whitespace")
        if(workFlowStateProcesses == null || workFlowStateProcesses.isEmpty())
            throw new Exception("The workFlowStateProcesses is null or empty")
        if(record == null)
            throw new Exception("The record is null or empty")
        def currentState = (TState)record.getClass().getDeclaredField(statePropertyName).get(record);
        def currentWorkFlowStateProcesses = workFlowStateProcesses.findAll{it.currentState == currentState}
        for(currentWorkFlowNextState in currentWorkFlowStateProcesses)
        {
            def result = currentWorkFlowNextState.proceedNextStateProcessWhen();
            if (result)
            {
                record = currentWorkFlowNextState.proceedNextStateProcess();
                break;
            }
        }
        return record;
    }
}
