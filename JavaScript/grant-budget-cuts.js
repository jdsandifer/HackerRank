// Find new grant cap so reduced budget can pay for current grants
// grantsArray is non-empty with positive doubles
// return value should be a double
function findGrantsCap( grantsArray, newBudget ) {
  // sort grantsArray ascending
  grantsArray.sort( (a, b) => a - b )
  
  // calculate amount as if all grants are the same
  const grantCount = grantsArray.length
  let possibleGrantCap = newBudget / grantCount
  let budgetLeft = newBudget
  let grantsLeft = grantCount
  let grant = 1    // current grant numbered starting at 1, use grant - 1 as index
  
  // walk through the grantsArray from the smallest to largest grant
  while ( grant <= grantCount ) {
    // if the current grant is more than the current cap, return the current cap
    let grantAmount = grantsArray[grant - 1]
    if ( grantAmount > possibleGrantCap ) {
      return possibleGrantCap
    }
    // otherwise, subtract current grant from new budget and recalc cap for remaining grants
    else {
      budgetLeft -= grantAmount
      grantsLeft--
      possibleGrantCap = budgetLeft / grantsLeft
    }
    grant++
  }
  return possibleGrantCap
}
