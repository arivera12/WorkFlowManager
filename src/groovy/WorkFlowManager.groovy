class WorkFlowManager<T, TState> implements IWorkFlowManager<T>
{
    T record
    String statePropertyName
    List<WorkFlowStateProcess<T, TState>> workFlowStateProcesses
    @Override
    T runWorkFlowProcess()
    {
        if(statePropertyName == null || statePropertyName.isEmpty() || statePropertyName.isAllWhitespace())
            throw new Exception("The statePropertyName is null, empty or whitespace")
        if(workFlowStateProcesses == null || workFlowStateProcesses.isEmpty())
            throw new Exception("The workFlowStateProcesses is null or empty")
        if(record == null)
            throw new Exception("The record is null")
        def currentStateProperty = record.getClass().getDeclaredField(statePropertyName).get(record)
        if(currentStateProperty == null)
            throw new Exception("The currentStateProperty is null")
        TState currentState = (TState)currentStateProperty
        def currentWorkFlowStateProcesses = workFlowStateProcesses.findAll{it.currentState == currentState}
        if(currentWorkFlowStateProcesses.isEmpty())
            throw new Exception("There are no steps available after the current state " + currentState.toString())
        for(currentWorkFlowNextState in currentWorkFlowStateProcesses)
        {
            def result = currentWorkFlowNextState.proceedNextStateProcessWhen()
            if (result)
            {
                record = currentWorkFlowNextState.proceedNextStateProcess()
                break
            }
        }
        return record
    }
}
