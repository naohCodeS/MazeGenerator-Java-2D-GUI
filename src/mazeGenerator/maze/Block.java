package mazeGenerator.maze;

/**
 * ���H��ʂŎg���u���b�N�̃R���|�[�l���g�̊�{�I�Ȍ`�����߂�N���X�ł�<br>
 * �ǁA�ʘH�A�X�^�[�g�Ȃǂ͂��̃N���X���p�������N���X�̃C���X�^���X�ł�
 * @author naohS
 *
 */
public class Block {
	
	private BlockType blockType;
	
	/**
	 * enum�^��BlockType�N���X��p���ău���b�N�̎�ނ����������܂�
	 */
	public Block() {
		this.setBlockType(BlockType.PATH);
	}
	
	/**
	 * �u���b�N�̎�ނ�ύX���܂�
	 * @param blockType �ύX����u���b�N�^�C�v
	 */
	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}
	
	/**
	 * ���݂̃u���b�N�^�C�v��Ԃ��܂�
	 * @return ���݂̃u���b�N�^�C�v
	 */
	public BlockType getBlockType() {
		return this.blockType;
	}
}
